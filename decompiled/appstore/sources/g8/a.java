package g8;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.obric.appstore.R;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f19995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f19996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f19997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f19998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f19999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f20000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f20001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f20002i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f20003j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AppInfo f20004k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f20005l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f20006m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f20007n;

    public a(JSONObject r10) {
        this.f19996c = r10.optString("title");
        this.f19997d = r10.optString("subtitle");
        this.f20002i = r10.optString("title2");
        this.f20003j = r10.optString("subtitle2");
        this.f20000g = r10.optString("pic_url");
        this.f19995b = r10.optString(AppPermissionActivity.EXTRA_APP_ICON_URL);
        this.f19998e = r10.optString(ServerElements.TOPIC_ID);
        this.f19999f = r10.optString("topic_name");
        this.f20006m = r10.optString("id");
        this.f20007n = r10.optString("online_time");
        if (p() == true) goto L15;
        this.f19994a = r10.optString(AppPermissionActivity.EXTRA_APP_PKG);
        String r11 = r10.optString("download_source");
        this.f20005l = r11;
        if (TextUtils.isEmpty(r11) == true) goto L16;
        JSONObject r12 = r10.optJSONObject(ServerElements.APP_INFO);     // Catch: Exception -> L10
        if (r12 == null) goto L17;
        AppInfo r13 = c9.a.R(r12, BaseApplication.c(), null);     // Catch: Exception -> L10
        this.f20004k = r13;     // Catch: Exception -> L10
        r13.mOnlineTime = this.f20007n;     // Catch: Exception -> L10
        return;
    L17:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        return;
    }

    public static a a(JSONObject r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        a r11 = new a(r10);
        if (r11.m() == false) goto L8;
        return r11;
    L8:
        r11.s("data is not available   ");
        return null;
    }

    public static Bitmap b(Drawable r10) {
        int r11 = r10.getIntrinsicWidth();
        int r12 = r10.getIntrinsicHeight();
        if (r10.getOpacity() == (-1)) goto L5;
        Bitmap.Config r13 = Bitmap.Config.ARGB_8888;
    L6:
        Bitmap r14 = Bitmap.createBitmap(r11, r12, r13);
        Canvas r15 = new Canvas(r14);
        r10.setBounds(0, 0, r10.getIntrinsicWidth(), r10.getIntrinsicHeight());
        r10.draw(r15);
        return r14;
    L5:
        r13 = Bitmap.Config.RGB_565;
        goto L6
    }

    public AppInfo c() {
        return this.f20004k;
    }

    public String d() {
        return this.f19995b;
    }

    public Bitmap e() {
        Drawable r10 = this.f20001h;
        if (r10 != null) goto L5;
    L8:
        if (r10 != null) goto L10;
        return null;
    L10:
        return b(r10);
    L5:
        if ((r10 instanceof BitmapDrawable) == false) goto L8;
        return ((BitmapDrawable) r10).getBitmap();
    }

    public String f() {
        return this.f19994a;
    }

    public String g() {
        return this.f20003j;
    }

    public String h() {
        return this.f20002i;
    }

    public String i() {
        return this.f19997d;
    }

    public String j() {
        return this.f19996c;
    }

    public String k() {
        return this.f19998e;
    }

    public String l() {
        return this.f19999f;
    }

    public final boolean m() {
        if (TextUtils.isEmpty(this.f19996c) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(this.f19997d) == true) goto L7;
        return true;
    }

    public boolean n() {
        return !TextUtils.isEmpty(this.f20006m);
    }

    public boolean o() {
        if (TextUtils.isEmpty(this.f20005l) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f20004k == null) goto L7;
        return true;
    }

    public boolean p() {
        if (TextUtils.isEmpty(this.f19998e) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(this.f19999f) == true) goto L7;
        return true;
    }

    public void q() {
        int r10 = BaseApplication.c().getResources().getDimensionPixelSize(R.dimen.notification_large_icon_inner_width);
        if (TextUtils.isEmpty(this.f20000g) == true) goto L8;
        String r11 = this.f20000g + "@!w" + r10;
        j.e("onThreadHandle :  mDisplayPic fist time load " + r11);
        Drawable r12 = r(r11);
        this.f20001h = r12;
        if (r12 != null) goto L8;
        j.e("loadPic :  mDisplayPic is null , so load again without params " + this.f20000g);
        this.f20001h = r(this.f20000g);
    L8:
        if (this.f20001h == null) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(this.f19995b) == true) goto L16;
        String r13 = this.f19995b + "@!w" + r10;
        j.e("onThreadHandle :  mNotifactionIcon fist time load " + r13);
        Drawable r14 = r(r13);
        this.f20001h = r14;
        if (r14 != null) goto L17;
        j.e("loadPic :  mNotifactionIcon is null , so load again without params " + this.f19995b);
        this.f20001h = r(this.f19995b);
        return;
    L17:
        return;
    }

    public final Drawable r(String r10) {
        Bitmap r11 = f8.a.c(BaseApplication.c(), r10);     // Catch: IOException -> L5
    L7:
        if (r11 != null) goto L9;
        return null;
    L9:
        return new BitmapDrawable(BaseApplication.c().getResources(), r11);
    L5:
        e = move-exception;
        e.printStackTrace();
        r11 = null;
        goto L7
    }

    public void s(String r10) {
        j.a("" + r10 + "PushEntity:  " + ("title: " + this.f19996c + "   subtitle: " + this.f19997d + "   topicid: " + this.f19998e + "   pic: " + this.f20000g));
    }
}
