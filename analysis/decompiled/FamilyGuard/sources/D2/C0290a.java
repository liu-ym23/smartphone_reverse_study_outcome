package D2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.familyguard.R;
import java.util.List;

/* renamed from: D2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0290a extends f<String, Drawable> {

    /* renamed from: h, reason: collision with root package name */
    private final PackageManager f1173h = P1.a.a().getPackageManager();

    C0290a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // D2.h
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public Drawable g(v<String> vVar) throws PackageManager.NameNotFoundException {
        Drawable applicationIcon;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(vVar.get());
        try {
            List<ResolveInfo> listQueryIntentActivities = this.f1173h.queryIntentActivities(intent, 0);
            if (listQueryIntentActivities == null || listQueryIntentActivities.size() <= 0) {
                try {
                    applicationIcon = this.f1173h.getApplicationIcon(vVar.get());
                } catch (PackageManager.NameNotFoundException e6) {
                    e6.printStackTrace();
                    return null;
                }
            } else {
                ResolveInfo resolveInfo = listQueryIntentActivities.get(0);
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo == null || TextUtils.isEmpty(activityInfo.packageName) || TextUtils.isEmpty(resolveInfo.activityInfo.name)) {
                    return null;
                }
                applicationIcon = resolveInfo.loadIcon(this.f1173h);
            }
            Bitmap bitmapE = C2.h.e(applicationIcon, P1.a.a().getResources().getDimensionPixelSize(R.dimen.us_progress_item_image_size));
            if (bitmapE == null) {
                return null;
            }
            return new BitmapDrawable(P1.a.a().getResources(), bitmapE);
        } catch (Exception e7) {
            Log.w("AppIconLoadTask", "getAppIcon exception:" + e7.getMessage());
            return null;
        }
    }
}
