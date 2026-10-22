package com.stepos.agentframework.chatcore.send;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.file.FileInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0088\u0001\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u0016R\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010!R%\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b&\u0010'R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b(\u0010$R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b,\u0010\u0016R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010-\u001a\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/stepos/agentframework/chatcore/send/e;", "", "", "text", "", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "images", "", "params", "Lcom/stepos/agentframework/chatcore/send/d;", "ids", "baseMeta", "", "useDeepThink", "agentId", "Lcom/stepos/agentframework/chatcore/send/l;", "slaAnchor", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Lcom/stepos/agentframework/chatcore/send/d;Ljava/util/Map;ZLjava/lang/String;Lcom/stepos/agentframework/chatcore/send/l;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Lcom/stepos/agentframework/chatcore/send/d;Ljava/util/Map;ZLjava/lang/String;Lcom/stepos/agentframework/chatcore/send/l;)Lcom/stepos/agentframework/chatcore/send/e;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/util/List;", "f", "()Ljava/util/List;", "Ljava/util/Map;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/Map;", "Lcom/stepos/agentframework/chatcore/send/d;", "e", "()Lcom/stepos/agentframework/chatcore/send/d;", Const.INTENT_KEY_UMID, "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "c", "Lcom/stepos/agentframework/chatcore/send/l;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/agentframework/chatcore/send/l;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.send.e, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class SendContext {
    private final String agentId;
    private final Map<String, String> baseMeta;
    private final PendingBubbleIds ids;
    private final List<FileInfo> images;
    private final Map<String, String> params;
    private final SlaSessionAnchor slaAnchor;
    private final String text;
    private final boolean useDeepThink;

    public SendContext(String str, List<FileInfo> list, Map<String, String> map, PendingBubbleIds ids, Map<String, String> baseMeta, boolean z10, String str2, SlaSessionAnchor lVar) {
        p.i(ids, "ids");
        p.i(baseMeta, "baseMeta");
        this.text = str;
        this.images = list;
        this.params = map;
        this.ids = ids;
        this.baseMeta = baseMeta;
        this.useDeepThink = z10;
        this.agentId = str2;
        this.slaAnchor = lVar;
    }

    public static /* synthetic */ SendContext b(SendContext sendContext, String str, List list, Map map, PendingBubbleIds pendingBubbleIds, Map map2, boolean z10, String str2, SlaSessionAnchor lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = sendContext.text;
        }
        if ((i10 & 2) != 0) {
            list = sendContext.images;
        }
        if ((i10 & 4) != 0) {
            map = sendContext.params;
        }
        if ((i10 & 8) != 0) {
            pendingBubbleIds = sendContext.ids;
        }
        if ((i10 & 16) != 0) {
            map2 = sendContext.baseMeta;
        }
        if ((i10 & 32) != 0) {
            z10 = sendContext.useDeepThink;
        }
        if ((i10 & 64) != 0) {
            str2 = sendContext.agentId;
        }
        if ((i10 & 128) != 0) {
            lVar = sendContext.slaAnchor;
        }
        String str3 = str2;
        SlaSessionAnchor lVar2 = lVar;
        Map map3 = map2;
        boolean z11 = z10;
        return sendContext.a(str, list, map, pendingBubbleIds, map3, z11, str3, lVar2);
    }

    public final SendContext a(String text, List<FileInfo> images, Map<String, String> params, PendingBubbleIds ids, Map<String, String> baseMeta, boolean useDeepThink, String agentId, SlaSessionAnchor slaAnchor) {
        p.i(ids, "ids");
        p.i(baseMeta, "baseMeta");
        return new SendContext(text, images, params, ids, baseMeta, useDeepThink, agentId, slaAnchor);
    }

    /* renamed from: c, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    public final Map<String, String> d() {
        return this.baseMeta;
    }

    /* renamed from: e, reason: from getter */
    public final PendingBubbleIds getIds() {
        return this.ids;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendContext)) {
            return false;
        }
        SendContext sendContext = (SendContext) other;
        return p.d(this.text, sendContext.text) && p.d(this.images, sendContext.images) && p.d(this.params, sendContext.params) && p.d(this.ids, sendContext.ids) && p.d(this.baseMeta, sendContext.baseMeta) && this.useDeepThink == sendContext.useDeepThink && p.d(this.agentId, sendContext.agentId) && p.d(this.slaAnchor, sendContext.slaAnchor);
    }

    public final List<FileInfo> f() {
        return this.images;
    }

    public final Map<String, String> g() {
        return this.params;
    }

    /* renamed from: h, reason: from getter */
    public final SlaSessionAnchor getSlaAnchor() {
        return this.slaAnchor;
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<FileInfo> list = this.images;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        Map<String, String> map = this.params;
        int iHashCode3 = (((((((iHashCode2 + (map == null ? 0 : map.hashCode())) * 31) + this.ids.hashCode()) * 31) + this.baseMeta.hashCode()) * 31) + Boolean.hashCode(this.useDeepThink)) * 31;
        String str2 = this.agentId;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        SlaSessionAnchor lVar = this.slaAnchor;
        return iHashCode4 + (lVar != null ? lVar.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getUseDeepThink() {
        return this.useDeepThink;
    }

    public String toString() {
        return "SendContext(text=" + this.text + ", images=" + this.images + ", params=" + this.params + ", ids=" + this.ids + ", baseMeta=" + this.baseMeta + ", useDeepThink=" + this.useDeepThink + ", agentId=" + this.agentId + ", slaAnchor=" + this.slaAnchor + ")";
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ SendContext(java.lang.String r12, java.util.List r13, java.util.Map r14, com.stepos.agentframework.chatcore.send.PendingBubbleIds r15, java.util.Map r16, boolean r17, java.lang.String r18, com.stepos.agentframework.chatcore.send.SlaSessionAnchor r19, int r20, kotlin.jvm.internal.i r21) {
        /*
            r11 = this;
            r0 = r20
            r1 = r0 & 32
            if (r1 == 0) goto L9
            r1 = 0
            r8 = r1
            goto Lb
        L9:
            r8 = r17
        Lb:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L12
            r9 = r2
            goto L14
        L12:
            r9 = r18
        L14:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L21
            r10 = r2
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r2 = r11
            goto L2a
        L21:
            r10 = r19
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
        L2a:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.send.SendContext.<init>(java.lang.String, java.util.List, java.util.Map, com.stepos.agentframework.chatcore.send.d, java.util.Map, boolean, java.lang.String, com.stepos.agentframework.chatcore.send.l, int, kotlin.jvm.internal.i):void");
    }
}
