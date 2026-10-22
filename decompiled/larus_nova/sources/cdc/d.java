package cdc;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.lark.widget.photopicker.animation.BaseData;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends BaseData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f23440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f23441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f23442f;

    public final Bundle a() {
        Bundle r100 = new Bundle();
        if (this.f23441e == null) goto L5;
        r100.putString(this.f23442f + ".imageFilePath", this.f23441e);
    L5:
        r100.putInt(this.f23442f + ".left", this.f23438b);
        r100.putInt(this.f23442f + ".top", this.f23437a);
        r100.putInt(this.f23442f + ".width", this.f23439c);
        r100.putInt(this.f23442f + ".height", this.f23440d);
        r100.putInt(this.f23442f + ".animationtype", BaseData.AnimationType.TRANSLATE_ANIMATION.getValue());
        return r100;
    }

    public d(Context r100, Bundle r101) {
        this.f23442f = (String) com.ss.android.lark.widget.photopicker.animation.c.b(r100, "APPLICATION_ID");
        this.f23437a = r101.getInt(this.f23442f + ".top");
        this.f23438b = r101.getInt(this.f23442f + ".left");
        this.f23439c = r101.getInt(this.f23442f + ".width");
        this.f23440d = r101.getInt(this.f23442f + ".height");
        this.f23441e = r101.getString(this.f23442f + ".imageFilePath");
    }

    public d(Context r100, int r101, int r102, int r103, int r104, String r105) {
        this.f23442f = (String) com.ss.android.lark.widget.photopicker.animation.c.b(r100, "APPLICATION_ID");
        this.f23438b = r101;
        this.f23437a = r102;
        this.f23439c = r103;
        this.f23440d = r104;
        this.f23441e = r105;
    }
}
