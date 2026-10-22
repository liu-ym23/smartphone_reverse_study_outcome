package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
class TypefaceCompatBaseImpl {
    private static final int INVALID_KEY = 0;
    private static final String TAG = "TypefaceCompatBaseImpl";
    private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> mFontFamilies;

    /* JADX INFO: loaded from: classes17.dex */
    public interface StyleExtractor<T> {
        int getWeight(T r100);

        boolean isItalic(T r100);
    }

    public static /* synthetic */ Typeface access$000(String r100) {
        return Typeface.createFromFile(r100);
    }

    public TypefaceCompatBaseImpl() {
        this.mFontFamilies = new ConcurrentHashMap();
    }

    public static Typeface INVOKESTATIC_androidx_core_graphics_TypefaceCompatBaseImpl_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile(String r100) {
        if (TypeFaceOptimizer.getSwitch() == false) goto L14;
        if (r100 == null) goto L14;
        if (TypeFaceLancet.cache.contains(r100) == true) goto L8;
        Typeface r101 = access$000(r100);
        if (r101 == null) goto L14;
        TypeFaceLancet.cache.put(r100, r101);
        return r101;
    L8:
        return (Typeface) TypeFaceLancet.cache.get(r100);
    L14:
        return access$000(r100);
    }

    private static long getUniqueKey(Typeface r100) {
        if (r100 != null) goto L8;
        return 0;
    L8:
        Field r101 = Typeface.class.getDeclaredField("native_instance");     // Catch: Throwable -> L7
        r101.setAccessible(true);     // Catch: Throwable -> L7
        return ((Number) r101.get(r100)).longValue();
    L10:
        return 0;
    }

    public FontResourcesParserCompat.FontFamilyFilesResourceEntry getFontFamily(Typeface r100) {
        long r101 = getUniqueKey(r100);
        if (r101 != 0) goto L7;
        return null;
    L7:
        return this.mFontFamilies.get(Long.valueOf(r101));
    }

    private void addFontFamily(Typeface r100, FontResourcesParserCompat.FontFamilyFilesResourceEntry r101) {
        long r102 = getUniqueKey(r100);
        if (r102 == 0) goto L6;
        this.mFontFamilies.put(Long.valueOf(r102), r101);
        return;
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry r100, int r101) {
        return (FontResourcesParserCompat.FontFileResourceEntry) findBestFont(r100.getEntries(), r101, new AnonymousClass2(this));
    }

    public Typeface createFromInputStream(Context r100, InputStream r101) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.io.File r2 = androidx.core.graphics.TypefaceCompatUtil.getTempFile(r2)
            r0 = 0
            if (r2 != 0) goto L8
            return r0
        L8:
            boolean r3 = androidx.core.graphics.TypefaceCompatUtil.copyToFile(r2, r3)     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            if (r3 != 0) goto L12
            r2.delete()
            return r0
        L12:
            java.lang.String r3 = r2.getPath()     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            android.graphics.Typeface r3 = INVOKESTATIC_androidx_core_graphics_TypefaceCompatBaseImpl_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile(r3)     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            r2.delete()
            return r3
        L1e:
            r3 = move-exception
            r2.delete()
            throw r3
        L23:
            r2.delete()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatBaseImpl.createFromInputStream(android.content.Context, java.io.InputStream):android.graphics.Typeface");
    }

    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] r100, int r101) {
        return (FontsContractCompat.FontInfo) findBestFont(r100, r101, new AnonymousClass1(this));
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry r100, int r101, boolean r102) {
        return (FontResourcesParserCompat.FontFileResourceEntry) findBestFont(r100.getEntries(), r101, r102, new AnonymousClass3(this));
    }

    private static <T> T findBestFont(T[] r100, int r101, StyleExtractor<T> r102) {
        if ((r101 & 1) != 0) goto L5;
        int r103 = 400;
    L7:
        if ((r101 & 2) == 0) goto L9;
        boolean r104 = true;
    L11:
        return (T) findBestFont(r100, r103, r104, r102);
    L9:
        r104 = false;
        goto L11
    L5:
        r103 = 700;
        goto L7
    }

    private static <T> T findBestFont(T[] r100, int r101, boolean r110, StyleExtractor<T> r111) {
        int r102 = r100.length;
        T r103 = null;
        int r104 = Integer.MAX_VALUE;
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L13;
        T r106 = r100[r105];
        int r107 = Math.abs(r111.getWeight(r106) - r101) * 2;
        if (r111.isItalic(r106) != r110) goto L7;
        int r108 = 0;
    L8:
        int r109 = r107 + r108;
        if (r103 == null) goto L11;
        if (r104 > r109) goto L11;
    L12:
        r105 = r105 + 1;
    L11:
        r103 = r106;
        r104 = r109;
        goto L12
    L7:
        r108 = 1;
        goto L8
    L13:
        return r103;
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context r100, FontResourcesParserCompat.FontFamilyFilesResourceEntry r101, Resources r102, int r110) {
        FontResourcesParserCompat.FontFileResourceEntry r103 = findBestEntry(r101, r110);
        if (r103 != null) goto L6;
        return null;
    L6:
        Typeface r104 = TypefaceCompat.createFromResourcesFontFile(r100, r102, r103.getResourceId(), r103.getFileName(), 0, r110);
        addFontFamily(r104, r101);
        return r104;
    }

    public Typeface createFromFontInfo(Context r100, CancellationSignal r101, FontsContractCompat.FontInfo[] r102, int r103) {
        InputStream r104 = null;
        if (r102.length >= 1) goto L19;
        return null;
    L19:
        InputStream r105 = r100.getContentResolver().openInputStream(findBestInfo(r102, r103).getUri());     // Catch: Throwable -> L12 IOException -> L15
    L21:
        Typeface r106 = createFromInputStream(r100, r105);     // Catch: Throwable -> L10 IOException -> L18
        TypefaceCompatUtil.closeQuietly(r105);
        return r106;
    L10:
        th = th;
        r104 = r105;
    L13:
        TypefaceCompatUtil.closeQuietly(r104);
        throw th;
    L16:
        TypefaceCompatUtil.closeQuietly(r105);
        return null;
    L15:
        r105 = null;
    L12:
        th = th;
        goto L13
    }

    public Typeface createFromFontInfoWithFallback(Context r100, CancellationSignal r101, List<FontsContractCompat.FontInfo[]> r102, int r103) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface createWeightStyle(Context r100, Typeface r101, int r102, boolean r103) {
        Typeface r104 = WeightTypefaceApi14.createWeightStyle(this, r100, r101, r102, r103);     // Catch: RuntimeException -> L4
    L5:
        if (r104 != null) goto L8;
        return r101;
    L8:
        return r104;
    L4:
        r104 = null;
        goto L5
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context r100, FontResourcesParserCompat.FontFamilyFilesResourceEntry r101, Resources r102, int r110, boolean r111) {
        FontResourcesParserCompat.FontFileResourceEntry r112 = findBestEntry(r101, r110, r111);
        if (r112 != null) goto L6;
        return null;
    L6:
        Typeface r103 = TypefaceCompat.createFromResourcesFontFile(r100, r102, r112.getResourceId(), r112.getFileName(), 0, 0);
        addFontFamily(r103, r101);
        return r103;
    }

    public Typeface createFromResourcesFontFile(Context r100, Resources r101, int r102, String r103, int r104) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.io.File r1 = androidx.core.graphics.TypefaceCompatUtil.getTempFile(r1)
            r4 = 0
            if (r1 != 0) goto L8
            return r4
        L8:
            boolean r2 = androidx.core.graphics.TypefaceCompatUtil.copyToFile(r1, r2, r3)     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            if (r2 != 0) goto L12
            r1.delete()
            return r4
        L12:
            java.lang.String r2 = r1.getPath()     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            android.graphics.Typeface r2 = INVOKESTATIC_androidx_core_graphics_TypefaceCompatBaseImpl_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile(r2)     // Catch: java.lang.Throwable -> L1e java.lang.RuntimeException -> L23
            r1.delete()
            return r2
        L1e:
            r2 = move-exception
            r1.delete()
            throw r2
        L23:
            r1.delete()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatBaseImpl.createFromResourcesFontFile(android.content.Context, android.content.res.Resources, int, java.lang.String, int):android.graphics.Typeface");
    }
}
