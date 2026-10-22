package com.bytedance.applet.model.bottomsheet;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.bytedance.ai.api.AppletBottomSheetButtonRole;
import com.bytedance.ai.api.AppletBottomSheetCancelSource;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f192088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super DialogFragment, ? super AppletBottomSheetButtonRole, Unit> f192089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super DialogFragment, ? super AppletBottomSheetCancelSource, Unit> f192090c;

    /* JADX INFO: renamed from: com.bytedance.applet.model.bottomsheet.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C2783a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192091a = null;

        static {
            int[] r100 = new int[AppletBottomSheetButtonRole.values().length];
            r100[AppletBottomSheetButtonRole.AGREE_MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AppletBottomSheetButtonRole.AGREE_SUB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AppletBottomSheetButtonRole.REJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f192091a = r100;
        }
    }

    public a() {
        this.f192088a = new Bundle();
    }
}
