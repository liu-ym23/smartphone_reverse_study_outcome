package ai.onnxruntime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class OnnxRuntime {
    static final String ONNXRUNTIME_JNI_LIBRARY_NAME = "onnxruntime4j_jni";
    static final String ONNXRUNTIME_LIBRARY_CUDA_NAME = "onnxruntime_providers_cuda";
    static final String ONNXRUNTIME_LIBRARY_DNNL_NAME = "onnxruntime_providers_dnnl";
    static final String ONNXRUNTIME_LIBRARY_NAME = "onnxruntime";
    static final String ONNXRUNTIME_LIBRARY_OPENVINO_NAME = "onnxruntime_providers_openvino";
    static final String ONNXRUNTIME_LIBRARY_ROCM_NAME = "onnxruntime_providers_rocm";
    static final String ONNXRUNTIME_LIBRARY_SHARED_NAME = "onnxruntime_providers_shared";
    static final String ONNXRUNTIME_LIBRARY_TENSORRT_NAME = "onnxruntime_providers_tensorrt";
    static final String ONNXRUNTIME_NATIVE_PATH = "onnxruntime.native.path";
    private static final int ORT_API_VERSION_1 = 1;
    private static final int ORT_API_VERSION_11 = 11;
    private static final int ORT_API_VERSION_13 = 13;
    private static final int ORT_API_VERSION_14 = 14;
    private static final int ORT_API_VERSION_2 = 2;
    private static final int ORT_API_VERSION_3 = 3;
    private static final int ORT_API_VERSION_7 = 7;
    private static final int ORT_API_VERSION_8 = 8;
    private static final int ORT_TRAINING_API_VERSION_1 = 1;
    private static String libraryDirPathProperty;
    static long ortApiHandle;
    static long ortTrainingApiHandle;
    static EnumSet<OrtProvider> providers;
    private static Path tempDirectory;
    static boolean trainingEnabled;
    private static String version;
    private static final Logger logger = Logger.getLogger(OnnxRuntime.class.getName());
    private static final String OS_ARCH_STR = initOsArch();
    private static boolean loaded = false;
    private static final Set<String> extractedSharedProviders = new HashSet();

    private OnnxRuntime() {
    }

    private static void cleanUp(File file) {
        if (file.exists()) {
            logger.log(Level.FINE, "Deleting " + file + " on exit");
            file.deleteOnExit();
        }
    }

    public static boolean extractCUDA() {
        return extractProviderLibrary(ONNXRUNTIME_LIBRARY_CUDA_NAME);
    }

    public static boolean extractDNNL() {
        return extractProviderLibrary(ONNXRUNTIME_LIBRARY_DNNL_NAME);
    }

    private static Optional<File> extractFromResources(String str) {
        String strMapLibraryName = mapLibraryName(str);
        String str2 = "/ai/onnxruntime/native/" + OS_ARCH_STR + '/' + strMapLibraryName;
        File file = tempDirectory.resolve(strMapLibraryName).toFile();
        try {
            InputStream resourceAsStream = OnnxRuntime.class.getResourceAsStream(str2);
            try {
                if (resourceAsStream == null) {
                    Optional<File> optionalEmpty = Optional.empty();
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                    }
                    return optionalEmpty;
                }
                logger.log(Level.FINE, "Attempting to load native library '" + str + "' from resource path " + str2 + " copying to " + file);
                byte[] bArr = new byte[4096];
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                while (true) {
                    try {
                        int i10 = resourceAsStream.read(bArr);
                        if (i10 == -1) {
                            fileOutputStream.close();
                            logger.log(Level.FINE, "Extracted native library '" + str + "' from resource path");
                            Optional<File> optionalOf = Optional.of(file);
                            resourceAsStream.close();
                            return optionalOf;
                        }
                        fileOutputStream.write(bArr, 0, i10);
                    } finally {
                    }
                }
            } catch (Throwable th) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e10) {
            logger.log(Level.WARNING, "Failed to extract library '" + str + "' from the resources", (Throwable) e10);
            return Optional.empty();
        } finally {
            cleanUp(file);
        }
    }

    public static boolean extractOpenVINO() {
        return extractProviderLibrary(ONNXRUNTIME_LIBRARY_OPENVINO_NAME);
    }

    public static synchronized boolean extractProviderLibrary(String str) {
        if (isAndroid()) {
            return false;
        }
        Set<String> set = extractedSharedProviders;
        if (set.contains(str)) {
            return true;
        }
        if (extractFromResources(str).isPresent()) {
            set.add(str);
            return true;
        }
        if (libraryDirPathProperty == null) {
            return false;
        }
        if (!Paths.get(libraryDirPathProperty, mapLibraryName(str)).toFile().exists()) {
            return false;
        }
        set.add(str);
        return true;
    }

    public static boolean extractROCM() {
        return extractProviderLibrary(ONNXRUNTIME_LIBRARY_ROCM_NAME);
    }

    public static boolean extractTensorRT() {
        return extractProviderLibrary(ONNXRUNTIME_LIBRARY_TENSORRT_NAME);
    }

    private static native String[] getAvailableProviders(long j10);

    public static synchronized void init() {
        if (loaded) {
            return;
        }
        tempDirectory = isAndroid() ? null : Files.createTempDirectory("onnxruntime-java", new FileAttribute[0]);
        try {
            libraryDirPathProperty = System.getProperty(ONNXRUNTIME_NATIVE_PATH);
            extractProviderLibrary(ONNXRUNTIME_LIBRARY_SHARED_NAME);
            load(ONNXRUNTIME_LIBRARY_NAME);
            load(ONNXRUNTIME_JNI_LIBRARY_NAME);
            long jInitialiseAPIBase = initialiseAPIBase(14);
            ortApiHandle = jInitialiseAPIBase;
            if (jInitialiseAPIBase == 0) {
                throw new IllegalStateException("There is a mismatch between the ORT class files and the ORT native library, and the native library could not be loaded");
            }
            long jInitialiseTrainingAPIBase = initialiseTrainingAPIBase(jInitialiseAPIBase, 14);
            ortTrainingApiHandle = jInitialiseTrainingAPIBase;
            trainingEnabled = jInitialiseTrainingAPIBase != 0;
            providers = initialiseProviders(ortApiHandle);
            version = initialiseVersion();
            loaded = true;
        } finally {
            Path path = tempDirectory;
            if (path != null) {
                cleanUp(path.toFile());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006d A[PHI: r1
      0x006d: PHI (r1v11 java.lang.String) = (r1v6 java.lang.String), (r1v7 java.lang.String), (r1v8 java.lang.String) binds: [B:25:0x006b, B:28:0x0075, B:31:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String initOsArch() {
        /*
            java.lang.String r0 = "os.name"
            java.lang.String r1 = "generic"
            java.lang.String r0 = java.lang.System.getProperty(r0, r1)
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toLowerCase(r2)
            java.lang.String r3 = "mac"
            boolean r3 = r0.contains(r3)
            if (r3 != 0) goto L48
            java.lang.String r3 = "darwin"
            boolean r3 = r0.contains(r3)
            if (r3 == 0) goto L1f
            goto L48
        L1f:
            java.lang.String r3 = "win"
            boolean r4 = r0.contains(r3)
            if (r4 == 0) goto L28
            goto L4a
        L28:
            java.lang.String r3 = "nux"
            boolean r3 = r0.contains(r3)
            if (r3 == 0) goto L33
            java.lang.String r3 = "linux"
            goto L4a
        L33:
            boolean r3 = isAndroid()
            if (r3 == 0) goto L3c
            java.lang.String r3 = "android"
            goto L4a
        L3c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Unsupported os:"
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L48:
            java.lang.String r3 = "osx"
        L4a:
            java.lang.String r0 = "os.arch"
            java.lang.String r0 = java.lang.System.getProperty(r0, r1)
            java.lang.String r0 = r0.toLowerCase(r2)
            java.lang.String r1 = "amd64"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L94
            java.lang.String r1 = "x86_64"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L65
            goto L94
        L65:
            java.lang.String r1 = "x86"
            boolean r2 = r0.startsWith(r1)
            if (r2 == 0) goto L6f
        L6d:
            r0 = r1
            goto L96
        L6f:
            java.lang.String r1 = "aarch64"
            boolean r2 = r0.startsWith(r1)
            if (r2 == 0) goto L78
            goto L6d
        L78:
            java.lang.String r1 = "ppc64"
            boolean r2 = r0.startsWith(r1)
            if (r2 == 0) goto L81
            goto L6d
        L81:
            boolean r1 = isAndroid()
            if (r1 == 0) goto L88
            goto L96
        L88:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Unsupported arch:"
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L94:
            java.lang.String r0 = "x64"
        L96:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r2 = 45
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ai.onnxruntime.OnnxRuntime.initOsArch():java.lang.String");
    }

    private static native long initialiseAPIBase(int i10);

    private static EnumSet<OrtProvider> initialiseProviders(long j10) {
        String[] availableProviders = getAvailableProviders(j10);
        EnumSet<OrtProvider> enumSetNoneOf = EnumSet.noneOf(OrtProvider.class);
        for (String str : availableProviders) {
            enumSetNoneOf.add(OrtProvider.mapFromName(str));
        }
        return enumSetNoneOf;
    }

    private static native long initialiseTrainingAPIBase(long j10, int i10);

    private static native String initialiseVersion();

    public static boolean isAndroid() {
        return System.getProperty("java.vendor", "generic").equals("The Android Project");
    }

    private static void load(String str) throws IOException {
        if (isAndroid()) {
            System.loadLibrary(ONNXRUNTIME_JNI_LIBRARY_NAME);
            return;
        }
        if (Boolean.TRUE.toString().equalsIgnoreCase(System.getProperty("onnxruntime.native." + str + ".skip"))) {
            logger.log(Level.FINE, "Skipping load of native library '" + str + "'");
            return;
        }
        String strMapLibraryName = mapLibraryName(str);
        if (libraryDirPathProperty != null) {
            Logger logger2 = logger;
            Level level = Level.FINE;
            StringBuilder sbQ = a0.a.q("Attempting to load native library '", str, "' from specified path: ");
            sbQ.append(libraryDirPathProperty);
            logger2.log(level, sbQ.toString());
            File file = Paths.get(libraryDirPathProperty, strMapLibraryName).toFile();
            String absolutePath = file.getAbsolutePath();
            if (!file.exists()) {
                throw new IOException(a.l("Native library '", str, "' not found at ", absolutePath));
            }
            System.load(absolutePath);
            logger2.log(level, "Loaded native library '" + str + "' from specified path");
            return;
        }
        String property = System.getProperty("onnxruntime.native." + str + ".path");
        if (property != null) {
            Logger logger3 = logger;
            Level level2 = Level.FINE;
            logger3.log(level2, a.l("Attempting to load native library '", str, "' from specified path: ", property));
            File file2 = new File(property);
            String absolutePath2 = file2.getAbsolutePath();
            if (!file2.exists()) {
                throw new IOException(a.l("Native library '", str, "' not found at ", absolutePath2));
            }
            System.load(absolutePath2);
            logger3.log(level2, "Loaded native library '" + str + "' from specified path");
            return;
        }
        Optional<File> optionalExtractFromResources = extractFromResources(str);
        if (optionalExtractFromResources.isPresent()) {
            System.load(optionalExtractFromResources.get().getAbsolutePath());
            logger.log(Level.FINE, "Loaded native library '" + str + "' from resource path");
            return;
        }
        Logger logger4 = logger;
        Level level3 = Level.FINE;
        logger4.log(level3, "Attempting to load native library '" + str + "' from library path");
        System.loadLibrary(str);
        logger4.log(level3, "Loaded native library '" + str + "' from library path");
    }

    private static String mapLibraryName(String str) {
        return System.mapLibraryName(str).replace("jnilib", "dylib");
    }

    public static String version() {
        return version;
    }
}
