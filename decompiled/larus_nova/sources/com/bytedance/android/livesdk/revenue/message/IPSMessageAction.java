package com.bytedance.android.livesdk.revenue.message;

import com.larus.media.MediaScene;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/message/IPSMessageAction;", "", "", "serverValue", "I", "getServerValue", "()I", "CHAT", "BUSINESS", "BASIC", MediaScene.SYSTEM, "UNKNOW", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IPSMessageAction extends Enum<IPSMessageAction> {
    public static final IPSMessageAction BASIC = null;
    public static final IPSMessageAction BUSINESS = null;
    public static final IPSMessageAction CHAT = null;
    public static final IPSMessageAction SYSTEM = null;
    public static final IPSMessageAction UNKNOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IPSMessageAction[] f157177a = null;
    private final int serverValue;

    static {
        IPSMessageAction r100 = new IPSMessageAction("CHAT", 0, 1);
        CHAT = r100;
        IPSMessageAction r101 = new IPSMessageAction("BUSINESS", 1, 3);
        BUSINESS = r101;
        IPSMessageAction r102 = new IPSMessageAction("BASIC", 2, 2);
        BASIC = r102;
        IPSMessageAction r103 = new IPSMessageAction(MediaScene.SYSTEM, 3, 4);
        SYSTEM = r103;
        IPSMessageAction r104 = new IPSMessageAction("UNKNOW", 4, 0);
        UNKNOW = r104;
        f157177a = new IPSMessageAction[]{r100, r101, r102, r103, r104};
    }

    public static IPSMessageAction valueOf(String r100) {
        return (IPSMessageAction) r27.a.a(IPSMessageAction.class, r100);
    }

    public static IPSMessageAction[] values() {
        return (IPSMessageAction[]) f157177a.clone();
    }

    public final int getServerValue() {
        return this.serverValue;
    }

    public IPSMessageAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.serverValue = r102;
    }
}
