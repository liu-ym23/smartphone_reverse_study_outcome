package b3b;

import android.view.View;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public interface i {
    void n(View r100, String r101, List<Object> r102, int r103);

    void s(View r100, ActivityTransitionLauncher.LocationInfo r101, PhotoItem r102, boolean r103, boolean r104, int r105, Message.SourceType r106);

    void v(View r100, PhotoItem r101, boolean r102);
}
