package com.obric.agent.im;

import com.obric.aiagent.assistant.idl.IFlowMessageIDL;
import com.obric.aiagent.assistant.idl.ak;
import com.obric.aiagent.assistant.idl.bean.Block;
import com.obric.aiagent.assistant.idl.bean.BlockContent;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.TextBlock;
import com.obric.aiagent.assistant.idl.bean.TextContent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.aa;
import d.h.b.o;
import d.n;
import d.n.m;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: IMMessageExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ boolean lambda$vx6IlfJ7v3JVTdEngK6VbIeniZo(Block r0) {
        return a(r0);
    }

    public static final String a(IMMessage r4) {
        o.e(r4, "<this>");
        Object r2 = null;
        if (r4.isBlockType() == false) goto L11;
        List<Block> r0 = b(r4);
        if (r0 != null) goto L30;
        IFlowMessageIDL r1 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getMainTxtContentFromMessage(r4);
    L30:
        return a(r0);
    L11:
        String r5 = r4.getContent();
        if (r5 == null) goto L31;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L19
        TextContent r6 = (TextContent) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r5, TextContent.class), TextContent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r6 == null) goto L16;
        String r7 = r6.text;     // Catch: Throwable -> L19
    L17:
        Object r8 = n.f(r7);     // Catch: Throwable -> L19
    L22:
        if (n.b(r8) == true) goto L26;
        r2 = r8;
    L26:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L16:
        r7 = null;
    L19:
        th = move-exception;
        n.a r9 = n.f38560a;
        r8 = n.f(d.o.a(th));
        goto L22
    L31:
        return null;
    }

    private static final String a(List<Block> r5) {
        Iterator r6 = m.a(p.y((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), $$Lambda$b$vx6IlfJ7v3JVTdEngK6VbIeniZo.INSTANCE).a();
    L4:
        if (r6.hasNext() == false) goto L11;
        Object r0 = r6.next();
        if (((Block) ZeusTransformUtils.preCheckCast(r0, Block.class, "com.obric.aiagent.plugin")).getBlockType() != 10000) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        Block r7 = (Block) ZeusTransformUtils.preCheckCast(r0, Block.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L25;
        BlockContent r8 = r7.getContent();
        if (r8 == null) goto L26;
        TextBlock r9 = r8.getTextBlock();
        if (r9 != null) goto L19;
        return null;
    L19:
        return r9.text;
    L26:
        return null;
    L25:
        return null;
    L8:
        r3 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }

    private static final boolean a(Block r3) {
        o.e(r3, "it");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3.getParentId(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return false;
    L11:
        if (r3.getBlockType() != 10040) goto L13;
        return false;
    L13:
        return true;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private static final List<Block> b(IMMessage r4) {
        List<Block> r0 = r4.getContentBlock();
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r5 = r4.getContent();
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        Object r3 = null;
        if (r2 == false) goto L25;
        return null;
    L25:
        n.a r6 = n.f38560a;     // Catch: Throwable -> L17
        Object r7 = n.f((List) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r5, new IMMessageExtKt$resolveBlocks$2$1().getType()), List.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L17
    L20:
        if (n.b(r7) == true) goto L24;
        r3 = r7;
    L24:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
    L17:
        th = move-exception;
        n.a r8 = n.f38560a;
        r7 = n.f(d.o.a(th));
        goto L20
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    }
}
