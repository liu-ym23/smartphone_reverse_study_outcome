package c3b;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.k;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements mcc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Chat f22353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f22354b;

    @Override // mcc.b
    public final boolean c(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "userId");
        return false;
    }

    public final Context getContext() {
        return this.f22354b;
    }

    public c(Chat r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f22353a = r100;
        this.f22354b = r101;
    }

    @Override // mcc.b
    public final void d(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "userId");
        ProfileSource.a r103 = new ProfileSource.a();
        r103.f420573e = r102;
        Chat r104 = this.f22353a;
        if (r104 == null) goto L5;
        String r105 = r104.getId();
    L6:
        r103.f420572d = r105;
        r103.f420570b = 1;
        r103.f420571c = k.a(this.f22353a);
        ProfileSource r106 = r103.a();
        ChatCoreModule.a().getProfileDependency().e(this.f22354b, r106);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
