package com.bytedance.android.livesdk.interactivity.comment.utils;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.widget.EditText;
import com.bytedance.android.live.core.utils.d2;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.comment.CommonInputParams;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.utils.u3;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputFilter f136261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f136262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EditText f136263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommonInputParams f136264d;

    public static final class a extends d2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f136265a;

        public a(j r100) {
            this.f136265a = r100;
        }

        @Override // com.bytedance.android.live.core.utils.d2, android.text.TextWatcher
        public final void afterTextChanged(Editable r110) {
            if (r110 == null) goto L5;
            String r100 = r110.toString();
            if (r100 == null) goto L5;
        L6:
            int r101 = this.f136265a.f136264d.f133031e;
            int r102 = TextUtils.getTrimmedLength(r100);
            u3.a r111 = u3.a(r110, r101);
            if (r111 == null) goto L9;
            int r103 = r111.f159177a;
            r102 = r111.f159178b;
            int r112 = r103;
        L10:
            j r104 = this.f136265a;
            r104.f136262b = r102;
            if (r102 <= r101) goto L13;
            EditText r105 = r104.f136263c;
            InputFilter.LengthFilter r106 = new InputFilter.LengthFilter(r100.length());
            r104.f136261a = r106;
            r105.setFilters(new InputFilter[]{r106});
        L16:
            if (r102 <= r101) goto L42;
            f2.c(s1.C(R.string.ttlive_input_max_counts, new Object[]{Integer.valueOf(this.f136265a.f136264d.f133031e)}), 1);
            int r107 = r100.length();
            if (r112 == 0) goto L20;
            r101 = Math.min(r112, r107);
        L28:
            this.f136265a.f136263c.setText(r100.substring(0, r101));
            EditText r113 = this.f136265a.f136263c;     // Catch: Exception -> L31
            r113.setSelection(r113.getText().length());     // Catch: Exception -> L31
            return;
        L31:
            e = move-exception;
            b0 r108 = b0.o();
            StackTraceElement[] r114 = e.getStackTrace();
            r108.getClass();
            com.bytedance.android.live.core.log.g.m(6, r114);
            return;
        L20:
            Iterator r115 = ((ArrayList) ab2.a.d(r100)).iterator();
        L22:
            if (r115.hasNext() == false) goto L28;
            db2.a r109 = (db2.a) r115.next();
            if (r109.f467798c <= r101) goto L22;
            int r116 = r109.f467797b;
            if (r101 < r116) goto L22;
            r101 = r116;
            goto L28
        L42:
            return;
        L13:
            EditText r117 = r104.f136263c;
            if (r104.f136261a == null) goto L16;
            r117.setFilters(new InputFilter[0]);
            r104.f136261a = null;
            goto L16
        L9:
            r112 = 0;
        L5:
            r100 = "";
            goto L6
        }
    }

    public j(EditText r100, CommonInputParams r101) {
        Intrinsics.checkNotNullParameter(r100, "inputEditText");
        Intrinsics.checkNotNullParameter(r101, "commonInputParams");
        this.f136263c = r100;
        this.f136264d = r101;
        r100.addTextChangedListener(new a(this));
    }
}
