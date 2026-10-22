package ac3;

import cc3.k;
import com.bytedance.android.ec.model.response.PromotionProductCommentPhotoDTO;
import com.bytedance.android.ec.model.response.anchorv3.PromotionVideoInfo;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import p53.i;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final String b(CommentNodeVO r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getUserCommentLevel");
        List<i> r101 = r100.getTagsInfo();
        if (r101 == null) goto L15;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((i) r103).f527781a, "2") == false) goto L6;
    L11:
        i r104 = (i) r103;
        if (r104 != null) goto L14;
        return "";
    L14:
        return String.valueOf(r104.f527782b);
    L10:
        r103 = null;
        goto L11
    L15:
        return "";
    }

    public static final k a(CommentNodeVO r110, int r111, int r112, int r113, String r114, CommentNodeVO r115) {
        Intrinsics.checkNotNullParameter(r110, "$this$getGalleryInfo");
        Intrinsics.checkNotNullParameter(r114, "commentSwitchType");
        Intrinsics.checkNotNullParameter(r115, "commentNodeVO");
        List<PromotionVideoInfo> r100 = r110.getVideoInfo();
        if (r100 == null) goto L5;
        int r101 = r100.size();
    L6:
        List<PromotionProductCommentPhotoDTO> r102 = r110.getImagesInfos();
        if (r102 == null) goto L9;
        int r103 = r102.size();
    L10:
        String r104 = b(r110);
        return new k(r111, r113, r101, r103, r114, String.valueOf(r110.getId()), r104, r112, r115);
    L9:
        r103 = 0;
        goto L10
    L5:
        r101 = 0;
        goto L6
    }
}
