package com.obric.structure.omvvm.core.util;

import kotlin.Metadata;

/* JADX INFO: compiled from: QIPresenter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/structure/omvvm/core/util/QBindState;", "", "desc", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "SYNC_BIND", "ASYNC_BIND", "SYNC_UNBIND", "ASYNC_UNBIND", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum QBindState extends Enum<QBindState> {
    private static final /* synthetic */ QBindState[] $VALUES = null;
    public static final QBindState ASYNC_BIND = null;
    public static final QBindState ASYNC_UNBIND = null;
    public static final QBindState SYNC_BIND = null;
    public static final QBindState SYNC_UNBIND = null;
    private final String desc;

    private static final /* synthetic */ QBindState[] $values() {
        return new QBindState[]{SYNC_BIND, ASYNC_BIND, SYNC_UNBIND, ASYNC_UNBIND};
    }

    public static QBindState valueOf(String r1) {
        return (QBindState) Enum.valueOf(QBindState.class, r1);
    }

    public static QBindState[] values() {
        return (QBindState[]) $VALUES.clone();
    }

    private QBindState(String r1, int r2, String r3) {
        super(r1, r2);
        this.desc = r3;
    }

    public final String getDesc() {
        return this.desc;
    }

    static {
        SYNC_BIND = new QBindState("SYNC_BIND", 0, "syncBind");
        ASYNC_BIND = new QBindState("ASYNC_BIND", 1, "asyncBind");
        SYNC_UNBIND = new QBindState("SYNC_UNBIND", 2, "syncUnbind");
        ASYNC_UNBIND = new QBindState("ASYNC_UNBIND", 3, "asyncUnbind");
        $VALUES = $values();
    }
}
