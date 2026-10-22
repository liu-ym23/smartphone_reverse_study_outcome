package ar9;

import com.larus.platform.model.music.ThirdPartyMusicPlatform;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16044a = null;

        static {
            int[] r100 = new int[ThirdPartyMusicPlatform.values().length];
            r100[ThirdPartyMusicPlatform.QQMusicType.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ThirdPartyMusicPlatform.LunaMusicType.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ThirdPartyMusicPlatform.Other.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ThirdPartyMusicPlatform.NetEaseMusicType.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f16044a = r100;
        }
    }

    public static final String a(List<? extends ThirdPartyMusicPlatform> r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        return CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, new ar9.a(), 30, null);
    }

    public static final String b(ThirdPartyMusicPlatform r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f16044a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "qq";
    L5:
        if (r101 != 2) goto L7;
        return "soda";
    L7:
        if (r101 != 3) goto L9;
        return "other";
    L9:
        if (r101 == 4) goto L11;
        return "";
    L11:
        return "neteasemusic";
    }
}
