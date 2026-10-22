package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphere;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.AuctionAtmosphere")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/AuctionAtmosphere;", "", "Lcom/bytedance/android/livesdk/livecommerce/model/CountdownAtmosphere;", "countDown", "Lcom/bytedance/android/livesdk/livecommerce/model/CountdownAtmosphere;", "Lcom/bytedance/android/livesdk/livecommerce/model/DigitalAtmosphere;", ECAuctionAtmosphere.TYPE_DIGITAL, "Lcom/bytedance/android/livesdk/livecommerce/model/DigitalAtmosphere;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuctionAtmosphere {
    public static final a Companion = null;

    @SerializedName("count_down")
    public CountdownAtmosphere countDown;

    @SerializedName(ECAuctionAtmosphere.TYPE_DIGITAL)
    public DigitalAtmosphere digital;

    public static final class a {
        public a() {
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
            	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
            	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
            	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
            */
        public static com.bytedance.android.ec.model.response.ECAuctionAtmosphere a(com.bytedance.android.livesdk.livecommerce.model.AuctionAtmosphere r23) {
            /*  JADX ERROR: Simple mode code generation failed
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: CONST_STR (r1v0 ?? I:java.lang.String) = "$this$convertToECAuctionAtmosphere" A[DECLARE_VAR] (LINE:16777218) in method: com.bytedance.android.livesdk.livecommerce.model.AuctionAtmosphere.a.a(com.bytedance.android.livesdk.livecommerce.model.AuctionAtmosphere):com.bytedance.android.ec.model.response.ECAuctionAtmosphere, file: classes10.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
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
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
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
                Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
                	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
                	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
                	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
                	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
                	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
                	... 48 more
                */
            /*
                r0 = r23
                java.lang.String r1 = "$this$convertToECAuctionAtmosphere"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                com.bytedance.android.ec.model.response.ECAuctionAtmosphere r1 = new com.bytedance.android.ec.model.response.ECAuctionAtmosphere
                com.bytedance.android.livesdk.livecommerce.model.CountdownAtmosphere r2 = r0.countDown
                java.lang.String r3 = "$this$convertToECAuctionAtmosphereData"
                if (r2 == 0) goto L5c
                com.bytedance.android.livesdk.livecommerce.model.CountdownAtmosphere$a r5 = com.bytedance.android.livesdk.livecommerce.model.CountdownAtmosphere.Companion
                r5.getClass()
                java.lang.String r5 = "$this$convertToECAuctionCountdownAtmosphere"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r5)
                com.bytedance.android.ec.model.response.ECAuctionCountdownAtmosphere r5 = new com.bytedance.android.ec.model.response.ECAuctionCountdownAtmosphere
                long r7 = r2.startTime
                long r9 = r2.endTime
                com.bytedance.android.livesdk.livecommerce.model.AtmosphereData r2 = r2.data
                if (r2 == 0) goto L4f
                com.bytedance.android.livesdk.livecommerce.model.AtmosphereData$a r6 = com.bytedance.android.livesdk.livecommerce.model.AtmosphereData.Companion
                r6.getClass()
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
                com.bytedance.android.ec.model.response.ECAuctionAtmosphereData r6 = new com.bytedance.android.ec.model.response.ECAuctionAtmosphereData
                java.lang.String r12 = r2.img
                java.lang.String r13 = r2.num
                java.lang.String r14 = r2.bgColor
                java.lang.String r15 = r2.borderColor
                r21 = r5
                long r4 = r2.leftMargin
                java.util.List<java.lang.String> r11 = r2.bgColors
                r22 = r1
                java.util.List<java.lang.String> r1 = r2.borderColors
                java.lang.String r2 = r2.topImg
                r18 = r11
                r11 = r6
                r16 = r4
                r19 = r1
                r20 = r2
                r11.<init>(r12, r13, r14, r15, r16, r18, r19, r20)
                r11 = r6
                goto L54
            L4f:
                r22 = r1
                r21 = r5
                r11 = 0
            L54:
                r6 = r21
                r6.<init>(r7, r9, r11)
                r5 = r21
                goto L5f
            L5c:
                r22 = r1
                r5 = 0
            L5f:
                com.bytedance.android.livesdk.livecommerce.model.DigitalAtmosphere r0 = r0.digital
                if (r0 == 0) goto La2
                com.bytedance.android.livesdk.livecommerce.model.DigitalAtmosphere$a r1 = com.bytedance.android.livesdk.livecommerce.model.DigitalAtmosphere.Companion
                r1.getClass()
                java.lang.String r1 = "$this$convertToECAuctionDigitalAtmosphere"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                com.bytedance.android.ec.model.response.ECAuctionDigitalAtmosphere r1 = new com.bytedance.android.ec.model.response.ECAuctionDigitalAtmosphere
                java.lang.String r2 = r0.frequencyKey
                long r6 = r0.frequencyCount
                com.bytedance.android.livesdk.livecommerce.model.AtmosphereData r0 = r0.data
                if (r0 == 0) goto L9a
                com.bytedance.android.livesdk.livecommerce.model.AtmosphereData$a r4 = com.bytedance.android.livesdk.livecommerce.model.AtmosphereData.Companion
                r4.getClass()
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
                com.bytedance.android.ec.model.response.ECAuctionAtmosphereData r4 = new com.bytedance.android.ec.model.response.ECAuctionAtmosphereData
                java.lang.String r9 = r0.img
                java.lang.String r10 = r0.num
                java.lang.String r11 = r0.bgColor
                java.lang.String r12 = r0.borderColor
                long r13 = r0.leftMargin
                java.util.List<java.lang.String> r15 = r0.bgColors
                java.util.List<java.lang.String> r3 = r0.borderColors
                java.lang.String r0 = r0.topImg
                r8 = r4
                r16 = r3
                r17 = r0
                r8.<init>(r9, r10, r11, r12, r13, r15, r16, r17)
                goto L9b
            L9a:
                r4 = 0
            L9b:
                r1.<init>(r2, r6, r4)
                r4 = r1
                r0 = r22
                goto La5
            La2:
                r0 = r22
                r4 = 0
            La5:
                r0.<init>(r5, r4)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.livesdk.livecommerce.model.AuctionAtmosphere.a.a(com.bytedance.android.livesdk.livecommerce.model.AuctionAtmosphere):com.bytedance.android.ec.model.response.ECAuctionAtmosphere");
        }

        public static com.bytedance.android.livesdk.livecommerce.intro.model.resp.d b(AuctionAtmosphere r110) {
            Intrinsics.checkNotNullParameter(r110, "$this$convertToIntroAuctionAtmosphere");
            CountdownAtmosphere r100 = r110.countDown;
            com.bytedance.android.livesdk.livecommerce.intro.model.resp.p r101 = null;
            ECUrlModel r102 = null;
            r102 = null;
            if (r100 == null) goto L17;
            CountdownAtmosphere.Companion.getClass();
            Intrinsics.checkNotNullParameter(r100, "$this$convertToIntroCountdownAtmosphere");
            long r103 = r100.startTime;
            long r104 = r100.endTime;
            AtmosphereData r105 = r100.data;
            if (r105 == null) goto L9;
            ECV2UrlPicture r106 = r105.leftIcon;
            if (r106 == null) goto L9;
            ECV2UrlPicture.Companion.getClass();
            ECUrlModel r107 = ECV2UrlPicture.a.a(r106);
        L10:
            AtmosphereData r108 = r100.data;
            if (r108 == null) goto L15;
            ECV2UrlPicture r109 = r108.bgImg;
            if (r109 == null) goto L15;
            ECV2UrlPicture.Companion.getClass();
            ECUrlModel r111 = ECV2UrlPicture.a.a(r109);
        L16:
            com.bytedance.android.livesdk.livecommerce.intro.model.resp.n r112 = new com.bytedance.android.livesdk.livecommerce.intro.model.resp.n(r103, r104, r107, r111);
        L18:
            DigitalAtmosphere r113 = r110.digital;
            if (r113 == null) goto L39;
            DigitalAtmosphere.Companion.getClass();
            Intrinsics.checkNotNullParameter(r113, "$this$convertToIntroDigitalAtmosphere");
            String r114 = r113.frequencyKey;
            long r115 = r113.frequencyCount;
            AtmosphereData r116 = r113.data;
            if (r116 == null) goto L25;
            ECV2UrlPicture r117 = r116.leftIcon;
            if (r117 == null) goto L25;
            ECV2UrlPicture.Companion.getClass();
            ECUrlModel r118 = ECV2UrlPicture.a.a(r117);
        L26:
            AtmosphereData r119 = r113.data;
            if (r119 == null) goto L29;
            String r120 = r119.num;
        L30:
            if (r120 != null) goto L32;
            r120 = "";
        L32:
            String r121 = r120;
            if (r119 == null) goto L37;
            ECV2UrlPicture r122 = r119.bgImg;
            if (r122 == null) goto L37;
            ECV2UrlPicture.Companion.getClass();
            r102 = ECV2UrlPicture.a.a(r122);
        L37:
            r101 = new com.bytedance.android.livesdk.livecommerce.intro.model.resp.p(r114, r115, r118, r102, r121);
            goto L39
        L29:
            r120 = null;
        L25:
            r118 = null;
        L39:
            return new com.bytedance.android.livesdk.livecommerce.intro.model.resp.d(r112, r101);
        L15:
            r111 = null;
        L9:
            r107 = null;
            goto L10
        L17:
            r112 = null;
            goto L18
        }
    }

    static {
        Companion = new a();
    }

    public AuctionAtmosphere() {
    }
}
