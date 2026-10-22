package com.bytedance.android.livesdk.chatroom.gamestickerv2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f106286a = 0;

    static {
    }

    public static int a(JSONObject r100) {
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
            java.lang.String r0 = ""
            java.lang.String r1 = "parseAppDataVersion error"
            java.lang.String r2 = "GameSeiParser"
            java.lang.String r3 = "app_data"
            r4 = 0
            boolean r5 = r6.has(r3)     // Catch: java.lang.OutOfMemoryError -> L3a java.lang.Exception -> L3f
            if (r5 == 0) goto L43
            java.lang.String r6 = com.bytedance.mt.protector.impl.JSONObjectProtectorUtils.getString(r6, r3)     // Catch: java.lang.OutOfMemoryError -> L3a java.lang.Exception -> L3f
            java.lang.String r3 = "\\\\"
            kotlin.text.Regex r5 = new kotlin.text.Regex     // Catch: java.lang.OutOfMemoryError -> L3a java.lang.Exception -> L3f
            r5.<init>(r3)     // Catch: java.lang.OutOfMemoryError -> L3a java.lang.Exception -> L3f
            java.lang.String r6 = r5.replace(r6, r0)     // Catch: java.lang.OutOfMemoryError -> L3a java.lang.Exception -> L3f
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)     // Catch: java.lang.OutOfMemoryError -> L3a java.lang.Exception -> L3f
            if (r0 != 0) goto L39
            java.lang.String r0 = " "
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)     // Catch: java.lang.OutOfMemoryError -> L3a java.lang.Exception -> L3f
            if (r0 == 0) goto L2d
            goto L39
        L2d:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.OutOfMemoryError -> L3a java.lang.Exception -> L3f
            r0.<init>(r6)     // Catch: java.lang.OutOfMemoryError -> L3a java.lang.Exception -> L3f
            java.lang.String r6 = "ver"
            int r6 = r0.optInt(r6)     // Catch: java.lang.OutOfMemoryError -> L3a java.lang.Exception -> L3f
            return r6
        L39:
            return r4
        L3a:
            r6 = move-exception
            com.bytedance.android.live.core.log.ALogger.e(r2, r1, r6)
            goto L43
        L3f:
            r6 = move-exception
            com.bytedance.android.live.core.log.ALogger.e(r2, r1, r6)
        L43:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.livesdk.chatroom.gamestickerv2.a.a(org.json.JSONObject):int");
    }

    public static Set b(JSONObject r100) {
        LinkedHashSet r101 = new LinkedHashSet();
    L25:
        e = move-exception;
        ALogger.e("GameSeiParser", "parseDisplayId error", e);
    L27:
        return r101;
    L23:
        e = move-exception;
        ALogger.e("GameSeiParser", "parseDisplayId error", e);
        goto L27
    L4:
        if (r100.has("multi_view_data") == false) goto L27;
        JSONObject r102 = r100.optJSONObject("multi_view_data");     // Catch: OutOfMemoryError -> L23 Exception -> L25
        if (r102 == null) goto L8;
        JSONArray r103 = r102.optJSONArray("displays");     // Catch: OutOfMemoryError -> L23 Exception -> L25
    L9:
        int r104 = 0;
        if (r103 == null) goto L12;
        int r105 = r103.length();     // Catch: OutOfMemoryError -> L23 Exception -> L25
    L13:
        if (r104 >= r105) goto L27;
        if (r103 == null) goto L16;
        JSONObject r106 = r103.optJSONObject(r104);     // Catch: OutOfMemoryError -> L23 Exception -> L25
    L17:
        if (r106 == null) goto L19;
        String r107 = r106.optString("display_id");     // Catch: OutOfMemoryError -> L23 Exception -> L25
    L20:
        if (r107 == null) goto L22;
        r101.add(r107);     // Catch: OutOfMemoryError -> L23 Exception -> L25
    L22:
        r104 = r104 + 1;
        goto L13
    L19:
        r107 = null;
        goto L20
    L16:
        r106 = null;
        goto L17
    L12:
        r105 = 0;
        goto L13
    L8:
        r103 = null;
        goto L9
    }
}
