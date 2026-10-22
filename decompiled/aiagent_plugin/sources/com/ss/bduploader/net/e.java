package com.ss.bduploader.net;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.ss.bduploader.s;
import java.util.HashMap;

/* JADX INFO: compiled from: BDUploadHostProcessor.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {
    private static final String TAG = "BDUploadHostProcessor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<d, Integer> f37526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h[] f37527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f37528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f37529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f37530e;
    private int f;
    private int g;

    public void a(int r8, b r9) {
        s.c(TAG, String.format("----processor pro msg what:%d host:%s info:%s", new Object[]{Integer.valueOf(r8), r9.f37517b, r9}));
        if (r8 == 0) goto L16;
        if (r8 != 1) goto L18;
        int[] r1 = this.f37528c;
        if (r1[0] == 1) goto L13;
        if (r1[0] == 2) goto L13;
        if (r1[0] != 3) goto L18;
    L13:
        if (r1[1] != 0) goto L18;
        s.c(TAG, String.format("main dns is not end and backup dns is idle call backup dns", new Object[0]));
        c(r8, r9);
    L18:
        s.c(TAG, String.format("****end processor pro msg what:%d host:%s info:%s", new Object[]{Integer.valueOf(r8), r9.f37517b, r9}));
        return;
    L16:
        if (this.f37528c[0] != 0) goto L18;
        s.c(TAG, String.format("main dns is idle call main dns", new Object[0]));
        c(r8, r9);
        goto L18
    }

    public boolean a(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        s.c(TAG, String.format("id: %s is empty", new Object[]{r8}));
        return false;
    L6:
        int r0 = 0;
    L8:
        if (r0 >= 2) goto L16;
        h[] r5 = this.f37527b;
        if (r5[r0] == null) goto L15;
        if (r8.equals(r5[r0].f37536e) == false) goto L15;
        s.c(TAG, String.format("id: %s is valid index: %d", new Object[]{r8, Integer.valueOf(r0)}));
        return true;
    L15:
        r0 = r0 + 1;
        goto L8
    L16:
        s.c(TAG, String.format("id: %s is valid", new Object[]{r8}));
        return false;
    }

    public void b(int r14, b r15) {
        s.c(TAG, String.format("----process result what:%d id:%s host:%s", new Object[]{Integer.valueOf(r14), r15.f37520e, r15.f37517b}));
        if (r14 == 2) goto L6;
        if (r14 == 3) goto L6;
    L8:
        String r6 = null;
    L10:
        if (TextUtils.isEmpty(r6) == false) goto L13;
        s.c(TAG, String.format("****process result err id is empty", new Object[0]));
        return;
    L13:
        int r7 = 0;
    L14:
        if (r7 >= 2) goto L26;
        h[] r8 = this.f37527b;
        if (r8[r7] == null) goto L25;
        if (r6.equals(r8[r7].f37536e) == false) goto L25;
        this.f37527b[r7].c();
        this.f37527b[r7] = null;
        if (r14 != 3) goto L22;
        this.f37528c[r7] = 3;
    L24:
        s.c(TAG, String.format("****process result parser index:%d is end, be close", new Object[]{Integer.valueOf(r7)}));
        goto L26
    L22:
        if (r14 != 2) goto L24;
        this.f37528c[r7] = 2;
    L25:
        r7 = r7 + 1;
    L26:
        if (r7 != 0) goto L29;
        if (r14 != 2) goto L29;
        s.c(TAG, String.format("mian dns parse error, try back up dns", new Object[0]));
        a(1, new b(c.f37522b, r15.f37517b, null, 0, null));
    L29:
        s.c(TAG, String.format("****end process result what:%d id:%s host:%s", new Object[]{Integer.valueOf(r14), r15.f37520e, r15.f37517b}));
        return;
    L6:
        if (r15 == null) goto L8;
        r6 = r15.f37520e;
        goto L10
    }

    public boolean a() {
        int r1 = 0;
    L4:
        if (r1 >= 2) goto L13;
        if (this.f37527b[r1] == null) goto L12;
        int[] r3 = this.f37528c;
        if (r3[r1] == 3) goto L12;
        if (r3[r1] == 2) goto L12;
        return false;
    L12:
        r1 = r1 + 1;
        goto L4
    L13:
        s.c(TAG, "all dns parse is end");
        return true;
    }

    private void c(int r6, b r7) {
        s.c(TAG, String.format("----do parse internal what:%d info:%s", new Object[]{Integer.valueOf(r6), r7}));
        if (r7 != null) goto L5;
        return;
    L5:
        if (r6 == 0) goto L7;
    L11:
        if (r6 == 1) goto L13;
    L15:
        s.c(TAG, String.format("****do parse internal end", new Object[0]));
        return;
    L13:
        if (this.f37527b[1] != null) goto L15;
        s.c(TAG, String.format("create backup dns type:%d host:%s", new Object[]{Integer.valueOf(this.f37530e), r7.f37517b}));
        this.f37528c[1] = 1;
        this.f37527b[1] = a(r7.f37517b, this.f, 1);
        this.f37527b[1].a();
        goto L15
    L7:
        if (this.f37527b[0] != null) goto L11;
        s.c(TAG, String.format("create main dns type:%d host:%s", new Object[]{Integer.valueOf(this.f37530e), r7.f37517b}));
        this.f37528c[0] = 1;
        this.f37527b[0] = a(r7.f37517b, this.f37530e, 0);
        this.f37527b[0].a();
        Message r8 = new Message();
        r8.what = 1;
        r8.obj = r7;
        if (this.g <= 0) goto L15;
        s.c(TAG, String.format("BackUpDelayedTime:%d send backup delay first", new Object[]{Integer.valueOf(this.f37530e)}));
        this.f37529d.sendMessageDelayed(r8, this.g * 1000);
        goto L15
    }

    private h a(String r5, int r6, int r7) {
        if (r6 == 1) goto L9;
        if (r6 == 2) goto L9;
        if (r6 == 3) goto L9;
        s.c(TAG, String.format("create local dns parser for host:%s type:%d", new Object[]{r5, Integer.valueOf(r6)}));
        return new l(r5, this.f37529d);
    L9:
        s.c(TAG, String.format("create http dns parser for host:%s type:%d", new Object[]{r5, Integer.valueOf(r6)}));
        return new j(r5, null, r6, this.f37529d);
    }
}
