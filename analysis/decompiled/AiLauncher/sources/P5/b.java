package P5;

import N5.n;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\r\u001a\u0004\b\u0014\u0010\u000fR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"LP5/b;", "LN5/n;", "", "cardId", "", "LP5/f;", DidiCardProvider.KEY_ITEMS, "bizChannel", "channelIconUrl", "", D6.a.KEY_TASK_STATUS, "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "getBizChannel", "getChannelIconUrl", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b extends n {
    private final String bizChannel;
    private final String cardId;
    private final String channelIconUrl;
    private final List<OrderActionItem> items;
    private final Integer taskStatus;

    public b() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // N5.n
    /* renamed from: a, reason: from getter */
    public String getCardId() {
        return this.cardId;
    }

    public final List<OrderActionItem> b() {
        return this.items;
    }

    /* renamed from: c, reason: from getter */
    public final Integer getTaskStatus() {
        return this.taskStatus;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String cardId, List<OrderActionItem> items, String str, String str2, Integer num) {
        super(cardId);
        p.i(cardId, "cardId");
        p.i(items, "items");
        this.cardId = cardId;
        this.items = items;
        this.bizChannel = str;
        this.channelIconUrl = str2;
        this.taskStatus = num;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ b(java.lang.String r2, java.util.List r3, java.lang.String r4, java.lang.String r5, java.lang.Integer r6, int r7, kotlin.jvm.internal.i r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r8 = r7 & 2
            if (r8 == 0) goto Le
            java.util.List r3 = Z8.C1173v.m()
        Le:
            r8 = r7 & 4
            r0 = 0
            if (r8 == 0) goto L14
            r4 = r0
        L14:
            r8 = r7 & 8
            if (r8 == 0) goto L19
            r5 = r0
        L19:
            r7 = r7 & 16
            if (r7 == 0) goto L24
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L2a
        L24:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L2a:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: P5.b.<init>(java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.i):void");
    }
}
