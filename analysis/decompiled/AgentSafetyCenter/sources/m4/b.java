package m4;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import f7.x;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.concurrent.Executor;
import stepos.support.v7.widget.a0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f8201a;

    /* renamed from: b, reason: collision with root package name */
    public Object f8202b;

    /* renamed from: c, reason: collision with root package name */
    public Object f8203c;

    /* renamed from: d, reason: collision with root package name */
    public Object f8204d;

    /* renamed from: e, reason: collision with root package name */
    public Object f8205e;

    /* renamed from: f, reason: collision with root package name */
    public Object f8206f;

    /* renamed from: g, reason: collision with root package name */
    public Object f8207g;

    public void a() {
        int i;
        Drawable drawable;
        String str;
        Drawable drawable2;
        if (this.f8201a) {
            return;
        }
        ((a0) this.f8202b).setTitle((CharSequence) this.f8207g);
        x xVar = (x) this.f8205e;
        int i3 = -1;
        String str2 = null;
        if (xVar != null) {
            i = xVar.f4029a;
            str = (String) xVar.f4030b;
            drawable = (Drawable) xVar.f4031c;
        } else {
            i = -1;
            drawable = null;
            str = null;
        }
        x xVar2 = (x) this.f8206f;
        if (xVar2 != null) {
            i3 = xVar2.f4029a;
            str2 = (String) xVar2.f4030b;
            drawable2 = (Drawable) xVar2.f4031c;
        } else {
            drawable2 = null;
        }
        ((a0) this.f8202b).n(0, str2, drawable2, (View.OnClickListener) this.f8204d);
        ((a0) this.f8202b).n(1, str, drawable, (View.OnClickListener) this.f8203c);
        View positiveItemView = ((a0) this.f8202b).getPositiveItemView();
        ((x) this.f8205e).getClass();
        positiveItemView.setEnabled(true);
        positiveItemView.setId(i);
        ((x) this.f8205e).getClass();
        x xVar3 = (x) this.f8205e;
        if (((Drawable) xVar3.f4031c) == null && TextUtils.isEmpty((String) xVar3.f4030b)) {
            positiveItemView.setVisibility(8);
        } else {
            positiveItemView.setVisibility(0);
        }
        View negativeItemView = ((a0) this.f8202b).getNegativeItemView();
        ((x) this.f8206f).getClass();
        negativeItemView.setEnabled(true);
        negativeItemView.setId(i3);
        ((x) this.f8206f).getClass();
        x xVar4 = (x) this.f8206f;
        if (((Drawable) xVar4.f4031c) == null && TextUtils.isEmpty((String) xVar4.f4030b)) {
            negativeItemView.setVisibility(8);
        } else {
            negativeItemView.setVisibility(0);
        }
    }

    public FileInputStream b(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e10) {
            String message = e10.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            ((e) this.f8203c).b();
            return null;
        }
    }

    public void c(int i, IOException iOException) {
        Executor executor = (Executor) this.f8202b;
        a aVar = new a(0);
        aVar.f8200h = this;
        aVar.f8198f = i;
        aVar.f8199g = iOException;
        VarHandle.storeStoreFence();
        executor.execute(aVar);
    }
}
