package com.bytedance.android.shopping.anchorv4.dto.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/base/LinkAction;", "", "", "action", "Ljava/lang/Integer;", "getAction", "()Ljava/lang/Integer;", "ACTION_SCHEMA", "ACTION_SPECIAL", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LinkAction extends Enum<LinkAction> {
    public static final LinkAction ACTION_SCHEMA = null;
    public static final LinkAction ACTION_SPECIAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkAction[] f166511a = null;
    private final Integer action;

    static {
        LinkAction r100 = new LinkAction("ACTION_SCHEMA", 0, 0);
        ACTION_SCHEMA = r100;
        LinkAction r101 = new LinkAction("ACTION_SPECIAL", 1, 1);
        ACTION_SPECIAL = r101;
        f166511a = new LinkAction[]{r100, r101};
    }

    public static LinkAction valueOf(String r100) {
        return (LinkAction) a.a(LinkAction.class, r100);
    }

    public static LinkAction[] values() {
        return (LinkAction[]) f166511a.clone();
    }

    public final Integer getAction() {
        return this.action;
    }

    public LinkAction(String r100, int r101, Integer r102) {
        super(r100, r101);
        this.action = r102;
    }
}
