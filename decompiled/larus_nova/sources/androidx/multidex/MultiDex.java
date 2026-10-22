package androidx.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.oat.Dex2OatHelper;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import dalvik.system.DexFile;
import el9.a;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.zip.ZipFile;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
public final class MultiDex {
    private static final String CODE_CACHE_NAME = "code_cache";
    private static final String CODE_CACHE_SECONDARY_FOLDER_NAME = "secondary-dexes";
    private static final boolean IS_VM_MULTIDEX_CAPABLE = false;
    private static final int MAX_SUPPORTED_SDK_VERSION = 20;
    private static final int MIN_SDK_VERSION = 4;
    private static final String NO_KEY_PREFIX = "";
    private static final String OLD_SECONDARY_FOLDER_NAME = "secondary-dexes";
    static final String TAG = "MultiDex";
    private static final int VM_WITH_MULTIDEX_VERSION_MAJOR = 2;
    private static final int VM_WITH_MULTIDEX_VERSION_MINOR = 1;
    private static final Set<File> installedApk = null;

    public static final class V14 {
        private static final int EXTRACTED_SUFFIX_LENGTH = 4;
        private final ElementConstructor elementConstructor;

        public interface ElementConstructor {
            Object newInstance(File r100, DexFile r101) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
        }

        public static class ICSElementConstructor implements ElementConstructor {
            private final Constructor<?> elementConstructor;

            public ICSElementConstructor(Class<?> r100) throws SecurityException, NoSuchMethodException {
                Constructor<?> r101 = r100.getConstructor(new Class[]{File.class, ZipFile.class, DexFile.class});
                this.elementConstructor = r101;
                r101.setAccessible(true);
            }

            @Override // androidx.multidex.MultiDex.V14.ElementConstructor
            public Object newInstance(File r100, DexFile r101) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
                return this.elementConstructor.newInstance(new Object[]{r100, new ZipFile(r100), r101});
            }
        }

        public static class JBMR11ElementConstructor implements ElementConstructor {
            private final Constructor<?> elementConstructor;

            public JBMR11ElementConstructor(Class<?> r100) throws SecurityException, NoSuchMethodException {
                Constructor<?> r101 = r100.getConstructor(new Class[]{File.class, File.class, DexFile.class});
                this.elementConstructor = r101;
                r101.setAccessible(true);
            }

            @Override // androidx.multidex.MultiDex.V14.ElementConstructor
            public Object newInstance(File r100, DexFile r101) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.elementConstructor.newInstance(new Object[]{r100, r100, r101});
            }
        }

        public static class JBMR2ElementConstructor implements ElementConstructor {
            private final Constructor<?> elementConstructor;

            public JBMR2ElementConstructor(Class<?> r100) throws SecurityException, NoSuchMethodException {
                Constructor<?> r101 = r100.getConstructor(new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class});
                this.elementConstructor = r101;
                r101.setAccessible(true);
            }

            @Override // androidx.multidex.MultiDex.V14.ElementConstructor
            public Object newInstance(File r100, DexFile r101) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.elementConstructor.newInstance(new Object[]{r100, Boolean.FALSE, r100, r101});
            }
        }

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        private V14() throws ClassNotFoundException, SecurityException, NoSuchMethodException {
            Class r100 = INVOKESTATIC_androidx_multidex_MultiDex$V14_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("dalvik.system.DexPathList$Element");
            ElementConstructor r101 = new ICSElementConstructor(r100);     // Catch: NoSuchMethodException -> L5
        L8:
            this.elementConstructor = r101;
            return;
        L5:
            r101 = new JBMR11ElementConstructor(r100);     // Catch: NoSuchMethodException -> L7
        L7:
            r101 = new JBMR2ElementConstructor(r100);
            goto L8
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_androidx_multidex_MultiDex$V14_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class r103 = access$000(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r104 = access$000(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        private Object[] makeDexElements(List<? extends File> r100) throws IOException, SecurityException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
            int r101 = r100.size();
            Object[] r102 = new Object[r101];
            int r103 = 0;
        L3:
            if (r103 >= r101) goto L5;
            File r104 = (File) ListProtector.get(r100, r103);
            r102[r103] = this.elementConstructor.newInstance(r104, DexFile.loadDex(r104.getPath(), optimizedPathFor(r104), 0));
            r103 = r103 + 1;
            goto L3
        L5:
            return r102;
        }

        private static String optimizedPathFor(File r100) {
            File r101 = r100.getParentFile();
            String r102 = r100.getName();
            return new File(r101, r102.substring(0, r102.length() - EXTRACTED_SUFFIX_LENGTH) + Dex2OatHelper.DEX_SUFFIX).getPath();
        }

        public static void install(ClassLoader r100, List<? extends File> r101) throws IOException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
            Object r102 = MultiDex.access$000(r100, "pathList").get(r100);
            Object[] r103 = new V14().makeDexElements(r101);
            MultiDex.access$100(r102, "dexElements", r103);     // Catch: NoSuchFieldException -> L5
            return;
        L5:
            MultiDex.access$100(r102, "pathElements", r103);
        }
    }

    public static final class V19 {
        private V19() {
        }

        public static void install(ClassLoader r100, List<? extends File> r101, File r102) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            Object r103 = MultiDex.access$000(r100, "pathList").get(r100);
            ArrayList r104 = new ArrayList();
            MultiDex.access$100(r103, "dexElements", makeDexElements(r103, new ArrayList(r101), r102, r104));
            if (r104.size() <= 0) goto L14;
            Iterator r105 = r104.iterator();
        L6:
            if (r105.hasNext() == false) goto L8;
            IOException r106 = (IOException) r105.next();
            goto L6
        L8:
            Field r107 = MultiDex.access$000(r103, "dexElementsSuppressedExceptions");
            IOException[] r108 = (IOException[]) r107.get(r103);
            if (r108 != null) goto L11;
            IOException[] r109 = (IOException[]) r104.toArray(new IOException[r104.size()]);
        L12:
            r107.set(r103, r109);
            IOException r110 = new IOException("I/O exception during makeDexElement");
            r110.initCause((Throwable) ListProtector.get(r104, 0));
            throw r110;
        L11:
            IOException[] r111 = new IOException[r104.size() + r108.length];
            r104.toArray(r111);
            System.arraycopy(r108, 0, r111, r104.size(), r108.length);
            r109 = r111;
            goto L12
        }

        private static Object[] makeDexElements(Object r100, ArrayList<File> r101, File r102, ArrayList<IOException> r103) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) MultiDex.access$200(r100, "makeDexElements", new Class[]{ArrayList.class, File.class, ArrayList.class}).invoke(r100, new Object[]{r101, r102, r103});
        }
    }

    public static final class V4 {
        private V4() {
        }

        public static void install(ClassLoader r110, List<? extends File> r111) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int r100 = r111.size();
            Field r101 = MultiDex.access$000(r110, "path");
            StringBuilder r102 = new StringBuilder((String) r101.get(r110));
            String[] r103 = new String[r100];
            File[] r104 = new File[r100];
            ZipFile[] r105 = new ZipFile[r100];
            DexFile[] r106 = new DexFile[r100];
            ListIterator<? extends File> r112 = r111.listIterator();
        L4:
            if (r112.hasNext() == false) goto L6;
            File r107 = r112.next();
            String r108 = r107.getAbsolutePath();
            r102.append(':');
            r102.append(r108);
            int r109 = r112.previousIndex();
            r103[r109] = r108;
            r104[r109] = r107;
            r105[r109] = new ZipFile(r107);
            r106[r109] = DexFile.loadDex(r108, r108 + Dex2OatHelper.DEX_SUFFIX, 0);
            goto L4
        L6:
            r101.set(r110, r102.toString());
            MultiDex.access$100(r110, "mPaths", r103);
            MultiDex.access$100(r110, "mFiles", r104);
            MultiDex.access$100(r110, "mZips", r105);
            MultiDex.access$100(r110, "mDexs", r106);
        }
    }

    private MultiDex() {
    }

    static {
        installedApk = new HashSet();
        IS_VM_MULTIDEX_CAPABLE = isVMMultidexCapable(System.getProperty("java.vm.version"));
    }

    private static void clearOldDexDir(Context r100) throws Exception {
        File r101 = new File(r100.getFilesDir(), "secondary-dexes");
        if (r101.isDirectory() == false) goto L23;
        r101.getPath();
        File[] r102 = r101.listFiles();
        if (r102 != null) goto L8;
        r101.getPath();
        return;
    L8:
        int r103 = r102.length;
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L16;
        File r105 = r102[r104];
        r105.getPath();
        r105.length();
        if (r105.delete() == true) goto L13;
        r105.getPath();
    L14:
        r104 = r104 + 1;
        goto L9
    L13:
        r105.getPath();
        goto L14
    L16:
        if (r101.delete() == true) goto L18;
        r101.getPath();
        return;
    L18:
        r101.getPath();
        return;
    }

    private static ApplicationInfo getApplicationInfo(Context r100) {
        return r100.getApplicationInfo();
    L4:
        return null;
    }

    public static void install(Context r100) {
        if (IS_VM_MULTIDEX_CAPABLE == false) goto L13;
        return;
    L13:
        ApplicationInfo r101 = getApplicationInfo(r100);     // Catch: Exception -> L10
        if (r101 != null) goto L8;
        return;
    L8:
        doInstallation(r100, new File(r101.sourceDir), new File(r101.dataDir), "secondary-dexes", "", true);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        throw new RuntimeException("MultiDex installation failed (" + e.getMessage() + ").");
    }

    public static boolean isVMMultidexCapable(String r100) {
        boolean r101 = false;
        if (r100 == null) goto L13;
        Matcher r102 = PatternProtector.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(r100);
        if (r102.matches() == false) goto L13;
        int r103 = CastIntegerProtector.parseInt(r102.group(1));     // Catch: NumberFormatException -> L14
        int r104 = CastIntegerProtector.parseInt(r102.group(2));     // Catch: NumberFormatException -> L14
        if (r103 > 2) goto L11;
        if (r103 != 2) goto L13;
        if (r104 < 1) goto L13;
    L11:
        r101 = true;
    L13:
        return r101;
    }

    private static void mkdirChecked(File r100) throws IOException {
        r100.mkdir();
        if (r100.isDirectory() == true) goto L10;
        File r101 = r100.getParentFile();
        if (r101 != null) goto L7;
        r100.getPath();
    L9:
        throw new IOException("Failed to create directory " + r100.getPath());
    L7:
        r100.getPath();
        r101.isDirectory();
        r101.isFile();
        r101.exists();
        r101.canRead();
        r101.canWrite();
        goto L9
    }

    public static /* synthetic */ Field access$000(Object r100, String r101) throws NoSuchFieldException {
        return findField(r100, r101);
    }

    private static Field findField(Object r100, String r101) throws NoSuchFieldException {
        Class<?> r102 = r100.getClass();
    L3:
        if (r102 == null) goto L10;
        Field r103 = r102.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L8
        if (r103.isAccessible() == true) goto L7;
        r103.setAccessible(true);     // Catch: NoSuchFieldException -> L8
    L7:
        return r103;
    L8:
        r102 = r102.getSuperclass();
        goto L3
    L10:
        throw new NoSuchFieldException("Field " + r101 + " not found in " + r100.getClass());
    }

    public static void installInstrumentation(Context r110, Context r111) {
        if (IS_VM_MULTIDEX_CAPABLE == false) goto L16;
        return;
    L16:
        ApplicationInfo r100 = getApplicationInfo(r110);     // Catch: Exception -> L13
        if (r100 != null) goto L8;
        return;
    L8:
        ApplicationInfo r101 = getApplicationInfo(r111);     // Catch: Exception -> L13
        if (r101 != null) goto L11;
        return;
    L11:
        String r102 = r110.getPackageName() + ".";     // Catch: Exception -> L13
        File r112 = new File(r101.dataDir);     // Catch: Exception -> L13
        doInstallation(r111, new File(r100.sourceDir), r112, r102 + "secondary-dexes", r102, false);     // Catch: Exception -> L13
        doInstallation(r111, new File(r101.sourceDir), r112, "secondary-dexes", "", false);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        throw new RuntimeException("MultiDex installation failed (" + e.getMessage() + ").");
    }

    public static /* synthetic */ void access$100(Object r100, String r101, Object[] r102) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        expandFieldArray(r100, r101, r102);
    }

    public static /* synthetic */ Method access$200(Object r100, String r101, Class[] r102) throws NoSuchMethodException {
        return findMethod(r100, r101, r102);
    }

    private static void expandFieldArray(Object r100, String r101, Object[] r102) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field r103 = findField(r100, r101);
        Object[] r104 = (Object[]) r103.get(r100);
        Object[] r105 = (Object[]) Array.newInstance(r104.getClass().getComponentType(), r104.length + r102.length);
        System.arraycopy(r104, 0, r105, 0, r104.length);
        System.arraycopy(r102, 0, r105, r104.length, r102.length);
        r103.set(r100, r105);
    }

    private static Method findMethod(Object r100, String r101, Class<?>... r102) throws NoSuchMethodException {
        Class<?> r103 = r100.getClass();
    L3:
        if (r103 == null) goto L10;
        Method r104 = r103.getDeclaredMethod(r101, r102);     // Catch: NoSuchMethodException -> L8
        if (r104.isAccessible() == true) goto L7;
        r104.setAccessible(true);     // Catch: NoSuchMethodException -> L8
    L7:
        return r104;
    L8:
        r103 = r103.getSuperclass();
        goto L3
    L10:
        throw new NoSuchMethodException("Method " + r101 + " with parameters " + Arrays.asList(r102) + " not found in " + r100.getClass());
    }

    private static File getDexDir(Context r100, File r101, String r102) throws IOException {
        File r103 = new File(r101, CODE_CACHE_NAME);
        mkdirChecked(r103);     // Catch: IOException -> L5
    L6:
        File r104 = new File(r103, r102);
        mkdirChecked(r104);
        return r104;
    L5:
        r103 = new File(r100.getFilesDir(), CODE_CACHE_NAME);
        mkdirChecked(r103);
        goto L6
    }

    private static void installSecondaryDexes(ClassLoader r100, File r101, List<? extends File> r102) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        if (r102.isEmpty() == true) goto L6;
        V19.install(r100, r102, r101);
        return;
    }

    private static void doInstallation(Context r100, File r101, File r102, String r103, String r104, boolean r105) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException {
        Set<File> r106 = installedApk;
        monitor-enter(r106);
    L36:
        th = move-exception;
        throw th;
    L5:
        if (r106.contains(r101) == false) goto L8;
        monitor-exit(r106);     // Catch: Throwable -> L36
        return;
    L8:
        r106.add(r101);     // Catch: Throwable -> L36
        System.getProperty("java.vm.version");     // Catch: Throwable -> L36
        ClassLoader r107 = r100.getClassLoader();     // Catch: RuntimeException -> L34 Throwable -> L36
        if (r107 != null) goto L41;
        monitor-exit(r106);     // Catch: Throwable -> L36
        return;
    L41:
        clearOldDexDir(r100);     // Catch: Throwable -> L39
    L14:
        File r108 = getDexDir(r100, r102, r103);     // Catch: Throwable -> L36
        MultiDexExtractor r109 = new MultiDexExtractor(r101, r108);     // Catch: Throwable -> L36
    L31:
        th = move-exception;
        r109.close();     // Catch: IOException -> L40 Throwable -> L36
    L33:
        throw th;     // Catch: Throwable -> L36
    L48:
        installSecondaryDexes(r107, r108, r109.load(r100, r104, false));     // Catch: IOException -> L19 Throwable -> L31
    L46:
        r109.close();     // Catch: IOException -> L25 Throwable -> L36
        e = null;
    L26:
        if (e != null) goto L29;
        monitor-exit(r106);     // Catch: Throwable -> L36
        return;
    L29:
        throw e;     // Catch: Throwable -> L36
    L25:
        e = e;
        goto L26
    L19:
        e = move-exception;
        if (r105 == true) goto L22;
        throw e;     // Catch: Throwable -> L31
    L22:
        installSecondaryDexes(r107, r108, r109.load(r100, r104, true));     // Catch: Throwable -> L31
        goto L46
    }
}
