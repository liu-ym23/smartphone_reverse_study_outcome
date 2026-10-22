package b6c;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.n0;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.impl.PerfLoadPicMonitor;
import com.ss.android.lark.log.Log;
import f6c.c;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: b6c.a$a, reason: collision with other inner class name */
    public static class C0273a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f17896a = null;

        static {
            f17896a = new a();
        }
    }

    public a() {
    }

    public final void a(Context r110, int r111, int r112, String r210, AppCompatImageView r211, int r212, int r213, PerfLoadPicMonitor.MonitorRequestListener r214, int r215, int r216, int r217, int r218) {
        if (r110 != null) goto L6;
        return;
    L6:
        if ((r110 instanceof Activity) == true) goto L8;
    L10:
        if (r212 < 0) goto L22;
        if (r211 == null) goto L22;
        if (r211.getTag(R.id.tag_first) == null) goto L18;
        if (r211.getTag(R.id.tag_first).equals(r210) == true) goto L18;
        r211.setImageResource(r212);
    L20:
        r211.setTag(R.id.tag_first, r210);
    L18:
        if (r211.getTag(R.id.tag_first) != null) goto L20;
        r211.setImageResource(r212);
    L22:
        if (n0.c(r210) == false) goto L32;
        Log.i("StickerApp", "current pic key is http.");
        IRequestCreator r100 = ImageLoader.with(r110).load(r210).override(r111, r112).dontAnimate(false).gifFileSize(r215).gifMaxWidth(r216).gifMaxHeight(r217);
        if (r218 <= 0) goto L26;
        ArrayList r101 = new ArrayList();
        r101.add(new CenterCrop());
        r101.add(new RoundedCorners(r218));
        r100.transforms(r101);
    L27:
        if (r212 != (-2)) goto L29;
        r100.placeholder(new c(r110));
    L30:
        r100.error(r110.getDrawable(r213)).listener(r214).into(new f6c.a(r211));
        return;
    L29:
        r100.placeholder(r212);
        goto L30
    L26:
        r100.centerCrop();
        goto L27
    L32:
        IRequestCreator r102 = ImageLoader.with(r110).load(new EncryptImage(r210)).override(r111, r112).dontAnimate(false).error(r110.getDrawable(r213)).listener(r214).gifFileSize(r215).gifMaxWidth(r216).gifMaxHeight(r217);
        if (r218 <= 0) goto L35;
        ArrayList r103 = new ArrayList();
        r103.add(new CenterCrop());
        r103.add(new RoundedCorners(r218));
        r102.transforms(r103);
    L36:
        if (r212 != (-2)) goto L38;
        r102.placeholder(new c(r110));
    L39:
        r102.into(new f6c.a(r211));
        return;
    L38:
        r102.placeholder(r212);
        goto L39
    L35:
        r102.centerCrop();
        goto L36
    L8:
        if (UIUtils.isActivityRunning((Activity) r110) == true) goto L10;
    }
}
