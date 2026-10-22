package com.bytedance.android.shopping.anchorv4.dto.elements;

import com.larus.bmhome.chat.bean.SuggestActionType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/elements/Mediatype;", "", "", "type", "I", "getType", "()I", SuggestActionType.PHOTO, "VIDEO", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Mediatype extends Enum<Mediatype> {
    public static final Mediatype PHOTO = null;
    public static final Mediatype VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Mediatype[] f166527a = null;
    private final int type;

    static {
        Mediatype r100 = new Mediatype(SuggestActionType.PHOTO, 0, 0);
        PHOTO = r100;
        Mediatype r101 = new Mediatype("VIDEO", 1, 1);
        VIDEO = r101;
        f166527a = new Mediatype[]{r100, r101};
    }

    public static Mediatype valueOf(String r100) {
        return (Mediatype) a.a(Mediatype.class, r100);
    }

    public static Mediatype[] values() {
        return (Mediatype[]) f166527a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public Mediatype(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
