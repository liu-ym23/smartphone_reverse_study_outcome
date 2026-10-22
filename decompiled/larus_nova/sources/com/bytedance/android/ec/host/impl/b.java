package com.bytedance.android.ec.host.impl;

import com.bytedance.android.ec.base.api.ai.AIChatMessage;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockMetaInfo;
import com.larus.im.bean.message.block.TextBlock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46198a = null;

        static {
            int[] r100 = new int[FloatChatWindowState.values().length];
            r100[FloatChatWindowState.Collapsed.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[FloatChatWindowState.Preview.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[FloatChatWindowState.Expanded.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f46198a = r100;
        }
    }

    public static final Object a(Message r210, Continuation r211) {
        if ((r211 instanceof ECAIChatComponentControllerKt$toECAIChatMessage$1) == false) goto L7;
        ECAIChatComponentControllerKt$toECAIChatMessage$1 r100 = (ECAIChatComponentControllerKt$toECAIChatMessage$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r105 = r100.I$2;
        int r106 = r100.I$1;
        int r107 = r100.I$0;
        String r108 = (String) r100.L$3;
        String r109 = (String) r100.L$2;
        String r110 = (String) r100.L$1;
        Message r111 = (Message) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r112 = r108;
        Object r113 = r102;
        r210 = r111;
        String r114 = r109;
        String r115 = r110;
    L84:
        String r116 = (String) r113;
        Map r117 = MapsKt.createMapBuilder();
        Map<String, String> r118 = r210.getExt();
        if (r118 == null) goto L87;
        r117.putAll(r118);
    L87:
        Unit r119 = Unit.INSTANCE;
        Map r120 = MapsKt.build(r117);
        if (r107 == 0) goto L90;
        boolean r121 = true;
    L91:
        if (r106 == 0) goto L93;
        boolean r122 = true;
    L94:
        if (r105 == 0) goto L96;
        boolean r123 = true;
    L98:
        return new AIChatMessage(r115, r114, null, r112, null, r121, r122, r123, r116, r120, 244, null);
    L96:
        r123 = false;
        goto L98
    L93:
        r122 = false;
        goto L94
    L90:
        r121 = false;
        goto L91
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        String r124 = r210.getLocalMessageId();
        if (r124 != null) goto L17;
        r124 = "";
    L17:
        String r125 = r124;
        String r126 = r210.getMessageId();
        if (r126 != null) goto L20;
    L25:
        String r127 = null;
    L26:
        String r128 = r210.getConversationId();
        if (r128 != null) goto L29;
    L34:
        String r129 = null;
    L35:
        r100.L$0 = r210;
        r100.L$1 = r125;
        r100.L$2 = r127;
        r100.L$3 = r129;
        r100.I$0 = 0;
        r100.I$1 = 0;
        r100.I$2 = 0;
        r100.label = 1;
        List<Block> r130 = r210.getContentBlock();
        if (r130 != null) goto L38;
        r130 = CollectionsKt.emptyList();
    L38:
        ArrayList r131 = new ArrayList();
        Iterator<T> r132 = r130.iterator();
    L40:
        if (r132.hasNext() == false) goto L50;
        Object r133 = r132.next();
        BlockContent r134 = ((Block) r133).getContent();
        if (r134 == null) goto L44;
        TextBlock r135 = r134.getTextBlock();
    L45:
        if (r135 == null) goto L47;
        boolean r136 = true;
    L48:
        if (r136 == false) goto L40;
        r131.add(r133);
        goto L40
    L47:
        r136 = false;
        goto L48
    L44:
        r135 = null;
        goto L45
    L50:
        ArrayList r137 = new ArrayList();
        Iterator r138 = r131.iterator();
    L52:
        if (r138.hasNext() == false) goto L80;
        List<BlockMetaInfo> r139 = ((Block) r138.next()).getMetaInfo();
        if (r139 != null) goto L56;
        r139 = CollectionsKt.emptyList();
    L56:
        ArrayList r140 = new ArrayList();
        Iterator<T> r141 = r139.iterator();
    L58:
        if (r141.hasNext() == false) goto L65;
        Object r142 = r141.next();
        if (((BlockMetaInfo) r142).type != 202) goto L62;
        boolean r143 = true;
    L63:
        if (r143 == false) goto L58;
        r140.add(r142);
        goto L58
    L62:
        r143 = false;
        goto L63
    L65:
        ArrayList r144 = new ArrayList();
        Iterator r145 = r140.iterator();
    L67:
        if (r145.hasNext() == false) goto L79;
        String r146 = ((BlockMetaInfo) r145.next()).infoV2;
        if (r146 != null) goto L71;
    L76:
        r146 = null;
    L77:
        if (r146 == null) goto L67;
        r144.add(r146);
        goto L67
    L71:
        if (r146.length() <= 0) goto L73;
        boolean r147 = true;
    L74:
        if (r147 == false) goto L76;
    L73:
        r147 = false;
        goto L74
    L79:
        CollectionsKt.addAll(r137, r144);
        goto L52
    L80:
        r113 = BuildersKt.withContext(Dispatchers.getIO(), new ECAIChatComponentControllerKt$toECPayload$2(r137, null), r100);
        if (r113 == r103) goto L115;
        r112 = r129;
        r105 = 0;
        r106 = 0;
        r107 = 0;
        r114 = r127;
        r115 = r125;
        goto L84
    L115:
        return r103;
    L29:
        if (r128.length() <= 0) goto L31;
        boolean r148 = true;
    L32:
        if (r148 == false) goto L34;
        r129 = r128;
        goto L35
    L31:
        r148 = false;
        goto L32
    L20:
        if (r126.length() <= 0) goto L22;
        boolean r149 = true;
    L23:
        if (r149 == false) goto L25;
        r127 = r126;
        goto L26
    L22:
        r149 = false;
    L7:
        r100 = new ECAIChatComponentControllerKt$toECAIChatMessage$1(r211);
        goto L8
    }
}
