package com.bytedance.android.ec.store.repository.vo;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/TextOverLengthStrategy;", "", "", "type", "I", "getType", "()I", "TRUNCATE", "END_ELLIPSIS", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TextOverLengthStrategy extends Enum<TextOverLengthStrategy> {
    public static final TextOverLengthStrategy END_ELLIPSIS = null;
    public static final TextOverLengthStrategy TRUNCATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextOverLengthStrategy[] f48452a = null;
    private final int type;

    static {
        TextOverLengthStrategy r100 = new TextOverLengthStrategy("TRUNCATE", 0, 1);
        TRUNCATE = r100;
        TextOverLengthStrategy r101 = new TextOverLengthStrategy("END_ELLIPSIS", 1, 2);
        END_ELLIPSIS = r101;
        f48452a = new TextOverLengthStrategy[]{r100, r101};
    }

    public static TextOverLengthStrategy valueOf(String r100) {
        return (TextOverLengthStrategy) r27.a.a(TextOverLengthStrategy.class, r100);
    }

    public static TextOverLengthStrategy[] values() {
        return (TextOverLengthStrategy[]) f48452a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public TextOverLengthStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
