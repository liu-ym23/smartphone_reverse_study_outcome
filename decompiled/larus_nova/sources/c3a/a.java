package c3a;

/* JADX INFO: loaded from: classes32.dex */
public final class a {
    public static final void a(boolean r100, boolean r101) {
        by7.a r102 = new by7.a("face_memory_pop_up_confirm");
        r102.d("pop_up_type", "first_time_auth");
        if (r100 == false) goto L5;
        String r103 = "confirm";
    L6:
        r102.d("confirm_choice", r103);
        if (r100 == false) goto L11;
        if (r101 == true) goto L11;
        String r104 = "fail";
    L12:
        r102.d("result", r104);
        r102.b();
        return;
    L11:
        r104 = "success";
        goto L12
    L5:
        r103 = "cancel";
        goto L6
    }
}
