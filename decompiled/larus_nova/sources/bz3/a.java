package bz3;

import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$PresenterTag;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.CmtInputPresenterManager;
import com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.CmtInputPresenterManager$build$1;
import hy3.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f21874a = 0;

    static {
    }

    public static com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.b a(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "mPageOwner");
        Intrinsics.checkNotNullParameter(r101, "service");
        com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.b r102 = new com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.b(new hy3.b(r100, r101, CommentPublishScene.COMMENT_LIST));
        r102.j(CommentConstants$PresenterTag.EMOJI);
        r102.j(CommentConstants$PresenterTag.EDIT);
        r102.j(CommentConstants$PresenterTag.KEYBOARD);
        r102.j(CommentConstants$PresenterTag.PUBLISH);
        r102.j(CommentConstants$PresenterTag.CHECKER);
        final CmtInputPresenterManager r103 = r102.f194425a;
        if (r103 == null) goto L11;
        r103.f194403a.f487630a.f195172d.getLifecycle().addObserver(new CmtInputPresenterManager$build$1(r103));
        Iterator r104 = ((ArrayList) r103.f194405c).iterator();
    L6:
        if (r104.hasNext() == false) goto L11;
        com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a r105 = (com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a) r104.next();
        if (r105.f194423f.a(r105.f194420c) == null) goto L10;
        com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a.C2797a r106 = r105.f194423f;
        Intrinsics.checkNotNullParameter(r106, "viewFinder");
        r105.f16805b = r106;
        r105.A(r106);
    L10:
        r105.E();
    L11:
        return r102;
    }
}
