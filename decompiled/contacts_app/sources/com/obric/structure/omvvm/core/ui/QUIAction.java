package com.obric.structure.omvvm.core.ui;

import kotlin.Metadata;

/* JADX INFO: compiled from: QUIAction.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/structure/omvvm/core/ui/QUIAction;", "", "(Ljava/lang/String;I)V", "NONE", "HIDE", "SHOW", "REPLACE", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum QUIAction extends Enum<QUIAction> {
    private static final /* synthetic */ QUIAction[] $VALUES = null;
    public static final QUIAction HIDE = null;
    public static final QUIAction NONE = null;
    public static final QUIAction REPLACE = null;
    public static final QUIAction SHOW = null;

    private static final /* synthetic */ QUIAction[] $values() {
        return new QUIAction[]{NONE, HIDE, SHOW, REPLACE};
    }

    public static QUIAction valueOf(String r1) {
        return (QUIAction) Enum.valueOf(QUIAction.class, r1);
    }

    public static QUIAction[] values() {
        return (QUIAction[]) $VALUES.clone();
    }

    private QUIAction(String r1, int r2) {
        super(r1, r2);
    }

    static {
        NONE = new QUIAction("NONE", 0);
        HIDE = new QUIAction("HIDE", 1);
        SHOW = new QUIAction("SHOW", 2);
        REPLACE = new QUIAction("REPLACE", 3);
        $VALUES = $values();
    }
}
