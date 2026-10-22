package com.stepos.ability.voicewakeup.service;

import java.io.Serializable;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3325a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ d(int i, S7.a aVar) {
        this.f3325a = 0;
        this.b = i;
        this.c = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
    @Override // S7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke() {
        /*
            r8 = this;
            int r0 = r8.f3325a
            switch(r0) {
                case 0: goto Lb4;
                case 1: goto L10;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r8.c
            kotlin.jvm.internal.Ref$IntRef r0 = (kotlin.jvm.internal.Ref$IntRef) r0
            int r8 = r8.b
            java.lang.String r8 = androidx.compose.ui.tooling.preview.datasource.LoremIpsum.a(r0, r8)
            return r8
        L10:
            java.lang.Object r0 = r8.c
            java.lang.String r0 = (java.lang.String) r0
            int r8 = r8.b
            com.stepos.ability.voicewakeup.service.l r1 = com.stepos.ability.voicewakeup.service.l.f3333a
            E4.e r2 = com.stepos.ability.voicewakeup.service.l.o
            if (r2 == 0) goto L2a
            java.io.File r2 = r2.a(r0)
            boolean r3 = r2.exists()
            if (r3 == 0) goto L2a
            boolean r2 = r2.delete()
        L2a:
            android.content.Context r2 = com.stepos.ability.voicewakeup.service.l.n
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L8e
            int r5 = r0.length()
            if (r5 != 0) goto L37
            goto L72
        L37:
            java.lang.String r5 = "removeTrained id="
            java.lang.String r5 = r5.concat(r0)
            java.lang.String r6 = "WakeupWordStorage"
            android.util.Log.i(r6, r5)
            java.util.Set r5 = D7.N.D(r2)
            boolean r6 = r5.contains(r0)
            if (r6 != 0) goto L4d
            goto L72
        L4d:
            android.content.Context r6 = r2.getApplicationContext()
            java.lang.String r7 = "voice_wakeup_active_word"
            android.content.SharedPreferences r6 = r6.getSharedPreferences(r7, r4)
            android.content.SharedPreferences$Editor r6 = r6.edit()
            java.lang.String r7 = "trained_ids"
            java.util.LinkedHashSet r5 = D7.N.H(r5, r0)
            android.content.SharedPreferences$Editor r5 = r6.putStringSet(r7, r5)
            java.lang.String r6 = "keyphrase_"
            java.lang.String r0 = r6.concat(r0)
            android.content.SharedPreferences$Editor r0 = r5.remove(r0)
            r0.apply()
        L72:
            java.util.Set r0 = D7.N.D(r2)
            boolean r0 = r0.isEmpty()
            if (r0 != r3) goto L8e
            android.content.Context r8 = com.stepos.ability.voicewakeup.service.l.n
            if (r8 == 0) goto L89
            android.content.ContentResolver r8 = r8.getContentResolver()
            java.lang.String r0 = "voice_wakeup_enabled"
            android.provider.Settings.Global.putInt(r8, r0, r4)
        L89:
            com.stepos.ability.voicewakeup.service.k r8 = com.stepos.ability.voicewakeup.service.l.v(r4)
            goto La7
        L8e:
            fa.a r0 = com.stepos.ability.voicewakeup.service.l.e()
            boolean r2 = com.stepos.ability.voicewakeup.service.l.k()
            if (r2 == 0) goto La3
            java.lang.Object r0 = r0.c
            E4.e r0 = (E4.e) r0
            boolean r0 = r0.b()
            if (r0 == 0) goto La3
            r4 = r3
        La3:
            com.stepos.ability.voicewakeup.service.k r8 = com.stepos.ability.voicewakeup.service.l.w(r8, r4)
        La7:
            com.stepos.ability.voicewakeup.service.l.m()
            boolean r8 = r8.f3332a
            if (r8 == 0) goto Lb1
            r1.r(r3)
        Lb1:
            C7.r r8 = C7.r.f317a
            return r8
        Lb4:
            int r0 = r8.b
            java.lang.Object r8 = r8.c
            S7.a r8 = (S7.a) r8
            com.stepos.ability.voicewakeup.service.l r1 = com.stepos.ability.voicewakeup.service.l.f3333a
            com.stepos.ability.voicewakeup.service.l.m()
            fa.a r2 = com.stepos.ability.voicewakeup.service.l.e()
            boolean r3 = com.stepos.ability.voicewakeup.service.l.k()
            r4 = 1
            if (r3 == 0) goto Ld6
            java.lang.Object r2 = r2.c
            E4.e r2 = (E4.e) r2
            boolean r2 = r2.b()
            if (r2 == 0) goto Ld6
            r2 = r4
            goto Ld7
        Ld6:
            r2 = 0
        Ld7:
            com.stepos.ability.voicewakeup.service.k r0 = com.stepos.ability.voicewakeup.service.l.w(r0, r2)
            boolean r0 = r0.f3332a
            if (r0 == 0) goto Le2
            r1.r(r4)
        Le2:
            if (r8 == 0) goto Lef
            androidx.compose.ui.text.d r0 = com.stepos.ability.voicewakeup.service.l.g
            H4.r r1 = new H4.r
            r2 = 6
            r1.<init>(r2, r8)
            r0.invoke(r1)
        Lef:
            C7.r r8 = C7.r.f317a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.voicewakeup.service.d.invoke():java.lang.Object");
    }

    public /* synthetic */ d(Serializable serializable, int i, int i6) {
        this.f3325a = i6;
        this.c = serializable;
        this.b = i;
    }
}
