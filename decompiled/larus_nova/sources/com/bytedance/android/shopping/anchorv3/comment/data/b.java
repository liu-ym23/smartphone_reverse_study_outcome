package com.bytedance.android.shopping.anchorv3.comment.data;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.model.response.f1;
import com.bytedance.android.shopping.anchorv3.comment.CommentViewModel;
import com.bytedance.android.shopping.anchorv3.comment.LoadState;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f164520f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p53.b f164521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p53.b f164522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StatTagItem f164523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f164524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CommentViewModel f164525e;

    public static final class a {
    }

    static {
    }

    public b(CommentViewModel r110) {
        Intrinsics.checkNotNullParameter(r110, "viewModel");
        this.f164525e = r110;
        new com.bytedance.android.shopping.anchorv3.comment.data.a();
        new MutableLiveData();
        new MutableLiveData();
        new MutableLiveData();
        new LinkedHashMap();
        this.f164523c = new StatTagItem(0, 0, null, null, 0, false, null, 0, 255, null);
    }

    public final void a(boolean r210, boolean r211, StatTagItem r212) {
        Intrinsics.checkNotNullParameter(r212, "curCheckedTagItem");
        f1 r100 = null;
        if (r210 == true) goto L13;
        ArrayList r101 = new ArrayList();
        p53.b r102 = this.f164521a;
        if (r102 == null) goto L9;
        List<CommentNodeVO> r103 = r102.f527768a;
        if (r103 == null) goto L9;
        r101.addAll(r103);
    L9:
        p53.b r104 = this.f164521a;
        if (r104 == null) goto L12;
        r100 = r104.f527770c;
    L12:
        LoadState r105 = LoadState.FAIL;
        int r106 = !r211 ? 1 : 0;
        boolean r107 = r212.isStat();
        this.f164521a = new p53.b(r101, false, r105, r106, null, r107, -1, r100, 0, 1574);
    L22:
        this.f164525e.getClass();
        return;
    L13:
        ArrayList r110 = new ArrayList();
        p53.b r108 = this.f164522b;
        if (r108 == null) goto L18;
        List<CommentNodeVO> r109 = r108.f527768a;
        if (r109 == null) goto L18;
        r110.addAll(r109);
    L18:
        p53.b r111 = this.f164522b;
        if (r111 == null) goto L21;
        r100 = r111.f527770c;
    L21:
        LoadState r112 = LoadState.FAIL;
        int r113 = !r211 ? 1 : 0;
        boolean r213 = r212.isStat();
        this.f164522b = new p53.b(r110, false, r112, r113, null, r213, 0, r100, 0, 1700);
        goto L22
    }
}
