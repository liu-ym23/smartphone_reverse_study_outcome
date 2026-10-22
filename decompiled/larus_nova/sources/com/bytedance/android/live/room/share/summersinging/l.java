package com.bytedance.android.live.room.share.summersinging;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.bpea.cert.token.TokenCert;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f100355e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintLayout f100356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f100357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f100358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.room.share.summersinging.a f100359d;

    public static final class a {
    }

    static {
    }

    public l(com.bytedance.android.live.room.share.summersinging.a r100) {
        Intrinsics.checkNotNullParameter(r100, "dataProvider");
        this.f100359d = r100;
    }

    public static void a(l r100, Context r101, Function1 r102) {
        if (r100.f100357b == false) goto L5;
        ALogger.i("GroupPhotoShareLayoutViewHolder", "call trySaveImg when isn't isSaving");
        return;
    L5:
        r100.f100357b = true;
        GroupPhotoShareLayoutViewHolder$trySaveImg$1 r103 = new GroupPhotoShareLayoutViewHolder$trySaveImg$1(r100, r101, r102, null);
        if (Build.VERSION.SDK_INT < 33) goto L8;
        r103.invoke2();
        return;
    L8:
        Activity r104 = ContextUtil.contextToActivity(r101);
        SettingKey<Boolean> r105 = m60.i.f512260a;
        new m60.i.b(r104).b(new n(r100, r103, null), null, TokenCert.Companion.with("bpea-live_group_photo_request_permission"), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
    }
}
