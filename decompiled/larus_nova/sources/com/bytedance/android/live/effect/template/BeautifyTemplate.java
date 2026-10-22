package com.bytedance.android.live.effect.template;

import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class BeautifyTemplate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f68830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<BeautifyContentType> f68831b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/effect/template/BeautifyTemplate$BeautifyContentType;", "", "BEAUTY_TEMPLATE", LocalSubStickerItem.BEAUTY_TYPE_BEAUTY, LocalSubStickerItem.BEAUTY_TYPE_FILTER, "AV_ADJUST", "MAKEUPS", "BODY_BEAUTY", "STICKER", "PRESETS", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum BeautifyContentType extends Enum<BeautifyContentType> {
        public static final BeautifyContentType AV_ADJUST = null;
        public static final BeautifyContentType BEAUTY = null;
        public static final BeautifyContentType BEAUTY_TEMPLATE = null;
        public static final BeautifyContentType BODY_BEAUTY = null;
        public static final BeautifyContentType FILTER = null;
        public static final BeautifyContentType MAKEUPS = null;
        public static final BeautifyContentType PRESETS = null;
        public static final BeautifyContentType STICKER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BeautifyContentType[] f68832a = null;

        static {
            BeautifyContentType r100 = new BeautifyContentType("BEAUTY_TEMPLATE", 0);
            BEAUTY_TEMPLATE = r100;
            BeautifyContentType r101 = new BeautifyContentType(LocalSubStickerItem.BEAUTY_TYPE_BEAUTY, 1);
            BEAUTY = r101;
            BeautifyContentType r102 = new BeautifyContentType(LocalSubStickerItem.BEAUTY_TYPE_FILTER, 2);
            FILTER = r102;
            BeautifyContentType r103 = new BeautifyContentType("AV_ADJUST", 3);
            AV_ADJUST = r103;
            BeautifyContentType r104 = new BeautifyContentType("MAKEUPS", 4);
            MAKEUPS = r104;
            BeautifyContentType r105 = new BeautifyContentType("BODY_BEAUTY", 5);
            BODY_BEAUTY = r105;
            BeautifyContentType r106 = new BeautifyContentType("STICKER", 6);
            STICKER = r106;
            BeautifyContentType r107 = new BeautifyContentType("PRESETS", 7);
            PRESETS = r107;
            f68832a = new BeautifyContentType[]{r100, r101, r102, r103, r104, r105, r106, r107};
        }

        public static BeautifyContentType valueOf(String r100) {
            return (BeautifyContentType) r27.a.a(BeautifyContentType.class, r100);
        }

        public static BeautifyContentType[] values() {
            return (BeautifyContentType[]) f68832a.clone();
        }

        public BeautifyContentType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public final int hashCode() {
        Iterator<T> r100 = this.f68831b.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + ((BeautifyContentType) r100.next()).hashCode();
        goto L4
    L6:
        return r101;
    }

    public final String toString() {
        return "BeautyFilterDialogTemplate(types=" + this.f68831b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BeautifyTemplate(List<? extends BeautifyContentType> r100) {
        Intrinsics.checkNotNullParameter(r100, "types");
        this.f68831b = r100;
        this.f68830a = true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        Object r101 = null;
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(BeautifyTemplate.class, r102)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L27;
        BeautifyTemplate r103 = (BeautifyTemplate) r100;
        if (r103.f68831b.size() == this.f68831b.size()) goto L16;
        return false;
    L16:
        Iterator<T> r104 = r103.f68831b.iterator();
    L18:
        if (r104.hasNext() == false) goto L22;
        Object r105 = r104.next();
        if ((!this.f68831b.contains((BeautifyContentType) r105)) == false) goto L18;
        r101 = r105;
    L22:
        if (r101 == null) goto L31;
        return false;
    L31:
        return true;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.effect.template.BeautifyTemplate");
    L8:
        r102 = null;
        goto L10
    }
}
