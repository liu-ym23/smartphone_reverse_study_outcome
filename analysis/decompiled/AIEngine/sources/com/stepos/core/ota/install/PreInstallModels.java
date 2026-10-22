package com.stepos.core.ota.install;

import a9.a;
import android.content.Context;
import android.util.Log;
import androidx.datastore.preferences.protobuf.b1;
import cb.s;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.common.runtime.EngineRuntimeConfig;
import com.stepos.core.common.storage.ModelPathStore;
import com.stepos.core.ota.OtaEngine;
import com.stepos.core.ota.adapter.AndroidOtaLogger;
import com.stepos.core.ota.crypto.AtRestSealer;
import com.stepos.core.ota.crypto.KeystoreAtRestKeyStore;
import com.stepos.core.ota.crypto.ModelCryptoImpl;
import com.stepos.core.ota.display.ModelDisplayResourceStore;
import com.stepos.core.ota.domain.UserUninstallPolicy;
import com.stepos.core.ota.storage.ModelsVersionStore;
import com.stepos.core.ota.storage.UserUninstallStore;
import fc.m;
import gc.o;
import gc.q;
import h0.e;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.b;
import kotlin.c;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import lb.d;
import lb.n;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PreInstallModels {
    private static final String BUNDLE_CONFIG = "bundle_config.json";
    private static final int FALLBACK_VERSION = 1;
    private static final String MANIFEST_NAME = "model_manifest.json";
    private static final String MARKER_NAME = ".installed";
    private static final String OWNER_NAME = ".preinstall_owner";
    private static final String SYSTEM_PRESET_DIR = "/system/media/models";
    private static final String TAG = "PreInstallModels";
    public static final PreInstallModels INSTANCE = new PreInstallModels();
    private static final Object lock = new Object();
    private static volatile PreInstallOptions defaultOptions = new PreInstallOptions(null, 0, false, false, false, 31, null);
    private static final ConcurrentHashMap.KeySetView<String, Boolean> extractingTypes = ConcurrentHashMap.newKeySet();
    private static final AtomicInteger activeExtractCount = new AtomicInteger(0);
    private static final d presetSealer$delegate = b.b(new a(21));
    private static final CopyOnWriteArrayList<OnSettledListener> settledListeners = new CopyOnWriteArrayList<>();
    private static final CopyOnWriteArrayList<OnModelInstalledListener> modelInstalledListeners = new CopyOnWriteArrayList<>();
    private static final List<PreInstallModel> models = b1.P(new PreInstallModel("imagematting", 2));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface OnModelInstalledListener {
        void onModelInstalled(String str);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface OnSettledListener {
        void onSettled();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class PreInstallModel {
        private final String modelType;
        private final int presetVersion;

        public PreInstallModel(String modelType, int i10) {
            g.f(modelType, "modelType");
            this.modelType = modelType;
            this.presetVersion = i10;
        }

        public static /* synthetic */ PreInstallModel copy$default(PreInstallModel preInstallModel, String str, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = preInstallModel.modelType;
            }
            if ((i11 & 2) != 0) {
                i10 = preInstallModel.presetVersion;
            }
            return preInstallModel.copy(str, i10);
        }

        public final String component1() {
            return this.modelType;
        }

        public final int component2() {
            return this.presetVersion;
        }

        public final PreInstallModel copy(String modelType, int i10) {
            g.f(modelType, "modelType");
            return new PreInstallModel(modelType, i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PreInstallModel)) {
                return false;
            }
            PreInstallModel preInstallModel = (PreInstallModel) obj;
            return g.b(this.modelType, preInstallModel.modelType) && this.presetVersion == preInstallModel.presetVersion;
        }

        public final File getDir() {
            return new File(ai.onnxruntime.a.k("/system/media/models/", this.modelType));
        }

        public final String getModelType() {
            return this.modelType;
        }

        public final int getPresetVersion() {
            return this.presetVersion;
        }

        public int hashCode() {
            return Integer.hashCode(this.presetVersion) + (this.modelType.hashCode() * 31);
        }

        public String toString() {
            return ai.onnxruntime.a.i("PreInstallModel(modelType=", this.presetVersion, this.modelType, ", presetVersion=", ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ExtractMode.values().length];
            try {
                iArr[ExtractMode.SYNC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExtractMode.ASYNC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExtractMode.SKIP_IF_MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PreInstallModels() {
    }

    public static /* synthetic */ void checkAndInstall$default(PreInstallModels preInstallModels, PreInstallOptions preInstallOptions, Context context, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            preInstallOptions = defaultOptions;
        }
        if ((i10 & 2) != 0) {
            context = null;
        }
        preInstallModels.checkAndInstall(preInstallOptions, context);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x01c2 A[LOOP:0: B:48:0x01bc->B:50:0x01c2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0241  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void doExtract(java.lang.String r34, java.io.File r35, com.stepos.core.ota.install.PreInstallOptions r36, android.content.Context r37) throws java.security.NoSuchAlgorithmException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 887
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.install.PreInstallModels.doExtract(java.lang.String, java.io.File, com.stepos.core.ota.install.PreInstallOptions, android.content.Context):void");
    }

    public static /* synthetic */ boolean extractNow$default(PreInstallModels preInstallModels, String str, boolean z, Context context, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z = false;
        }
        if ((i10 & 4) != 0) {
            context = null;
        }
        return preInstallModels.extractNow(str, z, context);
    }

    private final void fireModelInstalled(String str) {
        Object objA;
        CopyOnWriteArrayList<OnModelInstalledListener> copyOnWriteArrayList = modelInstalledListeners;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Log.i(TAG, ai.onnxruntime.a.i("fireModelInstalled(", copyOnWriteArrayList.size(), str, ") to ", " listener(s)"));
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            try {
                ((OnModelInstalledListener) it.next()).onModelInstalled(str);
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                Log.w(TAG, "listener.onModelInstalled failed: " + str, thB);
            }
        }
    }

    private final void fireSettled() {
        Object objA;
        CopyOnWriteArrayList<OnSettledListener> copyOnWriteArrayList = settledListeners;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Log.i(TAG, "fireSettled to " + copyOnWriteArrayList.size() + " listener(s)");
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            try {
                ((OnSettledListener) it.next()).onSettled();
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                Log.w(TAG, "listener.onSettled failed", thB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AtRestSealer getPresetSealer() {
        return (AtRestSealer) presetSealer$delegate.getValue();
    }

    private final void handleOne(String str, File file, PreInstallOptions preInstallOptions, Context context) {
        File file2;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            a0.a.A("preset dir not readable: ", str, TAG);
            return;
        }
        if (fileArrListFiles.length == 0) {
            a0.a.A("preset dir empty, skip: ", str, TAG);
            return;
        }
        int i10 = 0;
        for (File file3 : fileArrListFiles) {
            if (file3.isFile() && g.b(file3.getName(), BUNDLE_CONFIG)) {
                int presetVersionFromDir = readPresetVersionFromDir(file);
                if (isInstalled(str, presetVersionFromDir)) {
                    Log.d(TAG, "already installed (dir): " + str + " v>=" + presetVersionFromDir);
                    writePresetMeta(context, str, null, file);
                    return;
                }
                ModelsVersionStore.INSTANCE.setVersionCode(str, presetVersionFromDir);
                ModelPathStore modelPathStore = ModelPathStore.INSTANCE;
                String absolutePath = file.getAbsolutePath();
                g.e(absolutePath, "getAbsolutePath(...)");
                ModelPathStore.onDownloadComplete$default(modelPathStore, str, absolutePath, null, 4, null);
                writePresetMeta(context, str, null, file);
                StringBuilder sbF = e.f("preinstalled (dir): ", str, " v", presetVersionFromDir, " @ ");
                sbF.append(file);
                Log.i(TAG, sbF.toString());
                return;
            }
        }
        if (!preInstallOptions.getEnableZipPreset()) {
            a0.a.v("zip preset disabled by options, skip: ", str, TAG);
            return;
        }
        int length = fileArrListFiles.length;
        while (true) {
            if (i10 >= length) {
                file2 = null;
                break;
            }
            File file4 = fileArrListFiles[i10];
            if (file4.isFile()) {
                String name = file4.getName();
                g.e(name, "getName(...)");
                if (o.e0(name, ".zip", true)) {
                    file2 = file4;
                    break;
                }
            }
            i10++;
        }
        if (file2 == null) {
            a0.a.A("preset dir has neither bundle_config.json nor *.zip, skip: ", str, TAG);
        } else {
            scheduleZipExtract(str, file2, preInstallOptions, false, context);
        }
    }

    private final int peekZipVersion(File file) {
        Object objA;
        int iIntValue;
        try {
            ZipFile zipFile = new ZipFile(file);
            try {
                Integer zipVersion = readZipVersion(zipFile, "model_manifest.json", "version");
                if (zipVersion != null) {
                    iIntValue = zipVersion.intValue();
                } else {
                    Integer zipVersion2 = readZipVersion(zipFile, BUNDLE_CONFIG, "version_code");
                    iIntValue = zipVersion2 != null ? zipVersion2.intValue() : 1;
                }
                zipFile.close();
                objA = Integer.valueOf(iIntValue);
            } finally {
            }
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            Log.w(TAG, "peek zip version failed: " + file + ", fallback v1", thB);
            objA = 1;
        }
        return ((Number) objA).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AtRestSealer presetSealer_delegate$lambda$1() {
        AndroidOtaLogger androidOtaLogger = new AndroidOtaLogger();
        return new AtRestSealer(new KeystoreAtRestKeyStore(androidOtaLogger), new ModelCryptoImpl(), androidOtaLogger, new com.stepos.core.common.telemetry.b(18), null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean presetSealer_delegate$lambda$1$lambda$0(String modelId) {
        g.f(modelId, "modelId");
        return EngineRuntimeConfig.INSTANCE.shouldEncryptModel(modelId);
    }

    private final String readDescriptionFromDir(File file) {
        Object objA;
        File file2 = new File(file, BUNDLE_CONFIG);
        if (!file2.isFile()) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(wb.d.Z(file2, gc.a.f9106b));
            String strOptString = jSONObject.optString("description");
            boolean zT0 = q.t0(strOptString);
            objA = strOptString;
            if (zT0) {
                objA = jSONObject.optString("desc");
            }
        } catch (Throwable th) {
            objA = c.a(th);
        }
        return (String) (Result.b(objA) == null ? objA : "");
    }

    private final Integer readJsonVersion(File file, String str) {
        Object objA;
        Object obj = null;
        if (!file.isFile()) {
            return null;
        }
        try {
            int iOptInt = new JSONObject(wb.d.Z(file, gc.a.f9106b)).optInt(str, 0);
            objA = Integer.valueOf(iOptInt);
            if (iOptInt <= 0) {
                objA = null;
            }
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB == null) {
            obj = objA;
        } else {
            Log.w(TAG, "parse " + file.getName() + " failed: " + file, thB);
        }
        return (Integer) obj;
    }

    private final int readPresetVersionFromDir(File file) {
        Integer jsonVersion = readJsonVersion(new File(file, "model_manifest.json"), "version");
        if (jsonVersion != null) {
            return jsonVersion.intValue();
        }
        Integer jsonVersion2 = readJsonVersion(new File(file, BUNDLE_CONFIG), "version_code");
        if (jsonVersion2 != null) {
            return jsonVersion2.intValue();
        }
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    private final Integer readZipVersion(ZipFile zipFile, String str, String str2) {
        Object objA;
        ZipEntry next;
        ZipEntry entry = zipFile.getEntry(str);
        Object obj = null;
        if (entry == null) {
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            g.e(enumerationEntries, "entries(...)");
            Iterator it = ((fc.a) m.x(new mb.n(enumerationEntries))).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = 0;
                    break;
                }
                next = it.next();
                String name = ((ZipEntry) next).getName();
                g.e(name, "getName(...)");
                if (o.e0(name, "/" + str, false)) {
                    break;
                }
            }
            entry = next;
            if (entry == null) {
                return null;
            }
        }
        try {
            InputStream inputStream = zipFile.getInputStream(entry);
            g.e(inputStream, "getInputStream(...)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, gc.a.f9106b), PcmDumpBudget.HARD_MAX_DIR_MB);
            try {
                String strF = jd.b.F(bufferedReader);
                bufferedReader.close();
                int iOptInt = new JSONObject(strF).optInt(str2, 0);
                objA = Integer.valueOf(iOptInt);
                if (iOptInt <= 0) {
                    objA = null;
                }
            } finally {
            }
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB == null) {
            obj = objA;
        } else {
            a0.a.w("parse ", str, " failed in zip: ", thB.getMessage(), TAG);
        }
        return (Integer) obj;
    }

    private final boolean scheduleZipExtract(String str, File file, PreInstallOptions preInstallOptions, boolean z, Context context) {
        int iPeekZipVersion = (preInstallOptions.getSyncPeekZipVersion() || preInstallOptions.getZipExtractMode() == ExtractMode.SYNC) ? peekZipVersion(file) : 1;
        if (preInstallOptions.getSyncPeekZipVersion() || preInstallOptions.getZipExtractMode() == ExtractMode.SYNC) {
            if (isInstalled(str, iPeekZipVersion)) {
                Log.d(TAG, "already installed (zip): " + str + " v>=" + iPeekZipVersion);
                writePresetMeta(context, str, file, targetDirFor(str, iPeekZipVersion));
                return true;
            }
            File fileTargetDirFor = targetDirFor(str, iPeekZipVersion);
            if (new File(fileTargetDirFor, MARKER_NAME).isFile() && fileTargetDirFor.isDirectory()) {
                ModelsVersionStore.INSTANCE.setVersionCode(str, iPeekZipVersion);
                ModelPathStore modelPathStore = ModelPathStore.INSTANCE;
                String absolutePath = fileTargetDirFor.getAbsolutePath();
                g.e(absolutePath, "getAbsolutePath(...)");
                ModelPathStore.onDownloadComplete$default(modelPathStore, str, absolutePath, null, 4, null);
                writePresetMeta(context, str, file, fileTargetDirFor);
                StringBuilder sbF = e.f("preinstalled (zip, cached): ", str, " v", iPeekZipVersion, " @ ");
                sbF.append(fileTargetDirFor);
                Log.i(TAG, sbF.toString());
                return true;
            }
        }
        if (context != null) {
            ModelDisplayResourceStore.INSTANCE.stagePresetDisplayAsync(context, str, file, OtaEngine.INSTANCE.bucketDirOf(str));
        }
        if (preInstallOptions.getZipExtractMode() == ExtractMode.SKIP_IF_MISSING && !z) {
            writePresetMeta(context, str, file, targetDirFor(str, iPeekZipVersion));
            a0.a.y("zip preset skipped (SKIP_IF_MISSING), meta written: ", str, TAG);
            return false;
        }
        if (!extractingTypes.add(str)) {
            a0.a.v("extract already in-flight, skip: ", str, TAG);
            return false;
        }
        s sVar = new s(str, file, preInstallOptions, context, 2);
        int i10 = WhenMappings.$EnumSwitchMapping$0[preInstallOptions.getZipExtractMode().ordinal()];
        if (i10 == 1) {
            sVar.run();
            return true;
        }
        if (i10 != 2 && i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (activeExtractCount.get() >= preInstallOptions.getMaxConcurrentExtract()) {
            a0.a.u("extract concurrency cap reached (max=", preInstallOptions.getMaxConcurrentExtract(), "), queued: ", str, TAG);
        }
        Thread thread = new Thread(sVar, ai.onnxruntime.a.k("PreInstallExtract-", str));
        thread.setDaemon(true);
        thread.start();
        return true;
    }

    public static /* synthetic */ boolean scheduleZipExtract$default(PreInstallModels preInstallModels, String str, File file, PreInstallOptions preInstallOptions, boolean z, Context context, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            context = null;
        }
        return preInstallModels.scheduleZipExtract(str, file, preInstallOptions, z, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleZipExtract$lambda$17(String str, File file, PreInstallOptions preInstallOptions, Context context) {
        AtomicInteger atomicInteger = activeExtractCount;
        atomicInteger.incrementAndGet();
        try {
            PreInstallModels preInstallModels = INSTANCE;
            preInstallModels.doExtract(str, file, preInstallOptions, context);
            atomicInteger.decrementAndGet();
            ConcurrentHashMap.KeySetView<String, Boolean> keySetView = extractingTypes;
            keySetView.remove(str);
            if (keySetView.isEmpty()) {
                preInstallModels.fireSettled();
            }
        } catch (Throwable th) {
            try {
                Log.e(TAG, "extract preset failed: " + str, th);
            } finally {
                activeExtractCount.decrementAndGet();
                ConcurrentHashMap.KeySetView<String, Boolean> keySetView2 = extractingTypes;
                keySetView2.remove(str);
                if (keySetView2.isEmpty()) {
                    INSTANCE.fireSettled();
                }
            }
        }
    }

    private final void sealPresetIfEnabled(String str, File file) {
        Object objA;
        if (EngineRuntimeConfig.INSTANCE.getSnapshot().getModelEncryptionEnabled()) {
            try {
                int iIntValue = ((Number) BuildersKt__BuildersKt.runBlocking$default(null, new PreInstallModels$sealPresetIfEnabled$1$n$1(this, file, null), 1, null)).intValue();
                if (iIntValue > 0) {
                    Log.i(TAG, "at-rest sealed " + iIntValue + " weight file(s) for preset " + str + " @ " + file.getName());
                }
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                Log.w(TAG, "at-rest seal preset failed (non-fatal): " + str, thB);
            }
        }
    }

    private final String sha256(File file) throws NoSuchAlgorithmException, IOException {
        int i10;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), PcmDumpBudget.HARD_MAX_DIR_MB);
        try {
            byte[] bArr = new byte[PcmDumpBudget.HARD_MAX_DIR_MB];
            while (true) {
                int i11 = bufferedInputStream.read(bArr);
                if (i11 <= 0) {
                    break;
                }
                messageDigest.update(bArr, 0, i11);
            }
            n nVar = n.f10413a;
            bufferedInputStream.close();
            byte[] bArrDigest = messageDigest.digest();
            g.e(bArrDigest, "digest(...)");
            StringBuilder sb2 = new StringBuilder();
            sb2.append((CharSequence) "");
            int i12 = 0;
            for (byte b10 : bArrDigest) {
                i12++;
                if (i12 > 1) {
                    sb2.append((CharSequence) "");
                }
                sb2.append(sha256$lambda$45(b10));
            }
            sb2.append((CharSequence) "");
            return sb2.toString();
        } finally {
        }
    }

    private static final CharSequence sha256$lambda$45(byte b10) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
    }

    private final File targetDirFor(String str, int i10) {
        return new File(new File(OtaEngine.INSTANCE.bucketDirOf(str)), str + "-" + i10);
    }

    private final void unzipTo(File file, File file2) throws IOException {
        String canonicalPath = file2.getCanonicalPath();
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file), PcmDumpBudget.HARD_MAX_DIR_MB));
        try {
            for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                File file3 = new File(file2, nextEntry.getName());
                String canonicalPath2 = file3.getCanonicalPath();
                g.e(canonicalPath2, "getCanonicalPath(...)");
                if (!o.k0(canonicalPath2, canonicalPath + File.separator, false) && !g.b(file3.getCanonicalPath(), canonicalPath)) {
                    throw new SecurityException("zip slip detected: " + nextEntry.getName());
                }
                if (nextEntry.isDirectory()) {
                    file3.mkdirs();
                } else {
                    File parentFile = file3.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3), PcmDumpBudget.HARD_MAX_DIR_MB);
                    try {
                        jd.b.n(zipInputStream, bufferedOutputStream);
                        bufferedOutputStream.close();
                    } finally {
                    }
                }
                zipInputStream.closeEntry();
            }
            n nVar = n.f10413a;
            zipInputStream.close();
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0015 A[Catch: all -> 0x0013, TryCatch #0 {all -> 0x0013, blocks: (B:6:0x0008, B:8:0x000e, B:17:0x0044, B:11:0x0015, B:13:0x001d, B:14:0x0032, B:16:0x0038), top: B:24:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void writePresetMeta(android.content.Context r6, java.lang.String r7, java.io.File r8, java.io.File r9) {
        /*
            r5 = this;
            if (r6 != 0) goto L4
            goto L9c
        L4:
            java.lang.String r0 = "PreInstallModels"
            if (r8 == 0) goto L15
            boolean r1 = r8.isFile()     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L15
            long r1 = r8.length()     // Catch: java.lang.Throwable -> L13
            goto L44
        L13:
            r5 = move-exception
            goto L81
        L15:
            boolean r8 = r9.isDirectory()     // Catch: java.lang.Throwable -> L13
            r1 = 0
            if (r8 == 0) goto L44
            wb.c r8 = wb.d.b0(r9)     // Catch: java.lang.Throwable -> L13
            com.stepos.core.common.cloud.d r3 = new com.stepos.core.common.cloud.d     // Catch: java.lang.Throwable -> L13
            r4 = 21
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L13
            fc.f r4 = new fc.f     // Catch: java.lang.Throwable -> L13
            r4.<init>(r8, r3)     // Catch: java.lang.Throwable -> L13
            fc.f$a r8 = new fc.f$a     // Catch: java.lang.Throwable -> L13
            r8.<init>(r4)     // Catch: java.lang.Throwable -> L13
        L32:
            boolean r3 = r8.hasNext()     // Catch: java.lang.Throwable -> L13
            if (r3 == 0) goto L44
            java.lang.Object r3 = r8.next()     // Catch: java.lang.Throwable -> L13
            java.io.File r3 = (java.io.File) r3     // Catch: java.lang.Throwable -> L13
            long r3 = r3.length()     // Catch: java.lang.Throwable -> L13
            long r1 = r1 + r3
            goto L32
        L44:
            java.lang.String r5 = r5.readDescriptionFromDir(r9)     // Catch: java.lang.Throwable -> L13
            com.stepos.core.common.storage.PresetMetaStore r8 = com.stepos.core.common.storage.PresetMetaStore.INSTANCE     // Catch: java.lang.Throwable -> L13
            com.stepos.core.common.storage.PresetMetaStore$Meta r9 = new com.stepos.core.common.storage.PresetMetaStore$Meta     // Catch: java.lang.Throwable -> L13
            r9.<init>(r1, r5)     // Catch: java.lang.Throwable -> L13
            r8.setMeta(r6, r7, r9)     // Catch: java.lang.Throwable -> L13
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L13
            r6.<init>()     // Catch: java.lang.Throwable -> L13
            java.lang.String r8 = "writePresetMeta: "
            r6.append(r8)     // Catch: java.lang.Throwable -> L13
            r6.append(r7)     // Catch: java.lang.Throwable -> L13
            java.lang.String r8 = " size="
            r6.append(r8)     // Catch: java.lang.Throwable -> L13
            r6.append(r1)     // Catch: java.lang.Throwable -> L13
            java.lang.String r8 = " desc=\""
            r6.append(r8)     // Catch: java.lang.Throwable -> L13
            r6.append(r5)     // Catch: java.lang.Throwable -> L13
            java.lang.String r5 = "\""
            r6.append(r5)     // Catch: java.lang.Throwable -> L13
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L13
            int r5 = android.util.Log.d(r0, r5)     // Catch: java.lang.Throwable -> L13
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L13
            goto L85
        L81:
            kotlin.Result$Failure r5 = kotlin.c.a(r5)
        L85:
            java.lang.Throwable r5 = kotlin.Result.b(r5)
            if (r5 == 0) goto L9c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "writePresetMeta failed: "
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.util.Log.w(r0, r6, r5)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.install.PreInstallModels.writePresetMeta(android.content.Context, java.lang.String, java.io.File, java.io.File):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean writePresetMeta$lambda$26$lambda$24(File it) {
        g.f(it, "it");
        return it.isFile();
    }

    public final void addOnModelInstalledListener(OnModelInstalledListener listener) {
        g.f(listener, "listener");
        CopyOnWriteArrayList<OnModelInstalledListener> copyOnWriteArrayList = modelInstalledListeners;
        if (copyOnWriteArrayList.contains(listener)) {
            return;
        }
        copyOnWriteArrayList.add(listener);
    }

    public final void addOnSettledListener(OnSettledListener listener) {
        g.f(listener, "listener");
        CopyOnWriteArrayList<OnSettledListener> copyOnWriteArrayList = settledListeners;
        if (copyOnWriteArrayList.contains(listener)) {
            return;
        }
        copyOnWriteArrayList.add(listener);
    }

    public final void checkAndInstall(PreInstallOptions options, Context context) {
        g.f(options, "options");
        synchronized (lock) {
            File file = new File(SYSTEM_PRESET_DIR);
            if (!file.isDirectory()) {
                Log.i(TAG, "preset root not present: " + file + ", skip auto-scan");
                return;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                Log.w(TAG, "preset root not readable: " + file);
                return;
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    g.e(name, "getName(...)");
                    if (!o.k0(name, ".", false)) {
                        String name2 = file2.getName();
                        UserUninstallPolicy userUninstallPolicy = UserUninstallPolicy.INSTANCE;
                        UserUninstallStore userUninstallStore = UserUninstallStore.INSTANCE;
                        g.c(name2);
                        if (userUninstallPolicy.allowPresetRestore(userUninstallStore.contains(name2))) {
                            try {
                                INSTANCE.handleOne(name2, file2, options, context);
                                n nVar = n.f10413a;
                            } catch (Throwable th) {
                                Log.e(TAG, "handle preset failed: " + name2, th);
                            }
                        } else {
                            Log.i(TAG, "preset skip, user uninstalled: " + name2);
                        }
                    }
                }
            }
            n nVar2 = n.f10413a;
            if (extractingTypes.isEmpty()) {
                fireSettled();
            }
        }
    }

    public final boolean extractNow(String modelType, boolean z, Context context) {
        File file;
        g.f(modelType, "modelType");
        if (!UserUninstallPolicy.INSTANCE.allowPresetRestore(UserUninstallStore.INSTANCE.contains(modelType))) {
            Log.i(TAG, "extractNow skipped, user uninstalled: ".concat(modelType));
            return false;
        }
        File file2 = new File(SYSTEM_PRESET_DIR, modelType);
        if (!file2.isDirectory()) {
            Log.w(TAG, "extractNow: preset dir not found: ".concat(modelType));
            return false;
        }
        File[] fileArrListFiles = file2.listFiles();
        if (fileArrListFiles != null) {
            int length = fileArrListFiles.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    file = null;
                    break;
                }
                file = fileArrListFiles[i10];
                if (file.isFile()) {
                    String name = file.getName();
                    g.e(name, "getName(...)");
                    if (o.e0(name, ".zip", true)) {
                        break;
                    }
                }
                i10++;
            }
            if (file != null) {
                return scheduleZipExtract(modelType, file, PreInstallOptions.copy$default(defaultOptions, z ? ExtractMode.SYNC : ExtractMode.ASYNC, 0, false, false, false, 30, null), true, context);
            }
        }
        Log.w(TAG, "extractNow: no zip in preset dir: ".concat(modelType));
        return false;
    }

    public final PreInstallOptions getDefaultOptions() {
        return defaultOptions;
    }

    public final List<PreInstallModel> getModels() {
        return models;
    }

    public final boolean isExtracting(String modelType) {
        g.f(modelType, "modelType");
        return extractingTypes.contains(modelType);
    }

    public final boolean isInstalled(String modelType, int i10) {
        g.f(modelType, "modelType");
        return ModelsVersionStore.INSTANCE.getVersionCode(modelType) >= i10 && new File(ModelPathStore.INSTANCE.getPath(modelType)).isDirectory();
    }

    public final boolean isPreset(String modelType) {
        Object objA;
        g.f(modelType, "modelType");
        try {
            objA = Boolean.valueOf(new File(SYSTEM_PRESET_DIR, modelType).isDirectory());
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final void removeOnModelInstalledListener(OnModelInstalledListener listener) {
        g.f(listener, "listener");
        modelInstalledListeners.remove(listener);
    }

    public final void removeOnSettledListener(OnSettledListener listener) {
        g.f(listener, "listener");
        settledListeners.remove(listener);
    }

    public final void setDefaultOptions(PreInstallOptions preInstallOptions) {
        g.f(preInstallOptions, "<set-?>");
        defaultOptions = preInstallOptions;
    }

    public final boolean isInstalled(PreInstallModel model) {
        g.f(model, "model");
        return isInstalled(model.getModelType(), model.getPresetVersion());
    }
}
