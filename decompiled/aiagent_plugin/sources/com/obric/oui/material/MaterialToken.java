package com.obric.oui.material;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.ae;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: MaterialToken.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MaterialToken {
    public static final MaterialToken INSTANCE = null;
    public static final int MATERIAL_TOKEN_API_LEVEL = 4;
    public static final int MIN_SUPPORTED_MATERIAL_API_LEVEL = 1;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c[]> OUI_Bg_Floating = null;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c[]> OUI_Bg_Floating_Blue = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Floating_Blue_Dark = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Floating_Blue_Light = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Floating_Dark = null;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c[]> OUI_Bg_Floating_Fill = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Floating_Fill_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Fill_Fluid_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Fill_Fluid_Light = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Fill_Frost_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Fill_Frost_Light = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Floating_Fill_Light = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Fluid_Blue_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Fluid_Blue_Light = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Fluid_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Fluid_Light = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Fluid_Tinted_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Fluid_Tinted_Light = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Frost_Blue_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Frost_Blue_Light = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Frost_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Frost_Light = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Frost_Tinted_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Frost_Tinted_Light = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Floating_Light = null;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c[]> OUI_Bg_Floating_OnImage = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Floating_OnImage_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_OnImage_Fluid_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_OnImage_Fluid_Light = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_OnImage_Frost_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_OnImage_Frost_Light = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Floating_OnImage_Light = null;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c[]> OUI_Bg_Floating_Overlay = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Floating_Overlay_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Overlay_Fluid_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Overlay_Fluid_Light = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Overlay_Frost_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Overlay_Frost_Light = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Floating_Overlay_Light = null;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c[]> OUI_Bg_Floating_Ring = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Floating_Ring_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Ring_Fluid_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Ring_Fluid_Light = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Ring_Frost_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Floating_Ring_Frost_Light = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Floating_Ring_Light = null;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c[]> OUI_Bg_Floating_Tinted = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Floating_Tinted_Dark = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Floating_Tinted_Light = null;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c[]> OUI_Bg_Modal = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Modal_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Modal_Fluid_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Modal_Fluid_Light = null;
    public static final com.obric.oui.material.c OUI_Bg_Modal_Frost_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Modal_Frost_Light = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Modal_Light = null;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c[]> OUI_Bg_Overlay_Search = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Overlay_Search_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Overlay_Search_Fluid_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Overlay_Search_Fluid_Light = null;
    public static final com.obric.oui.material.c OUI_Bg_Overlay_Search_Frost_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Overlay_Search_Frost_Light = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Overlay_Search_Light = null;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c[]> OUI_Bg_Popup = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Popup_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Popup_Fluid_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Popup_Fluid_Light = null;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c> OUI_Bg_Popup_Frost = null;
    public static final com.obric.oui.material.c OUI_Bg_Popup_Frost_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Popup_Frost_Light = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Popup_Light = null;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c[]> OUI_Bg_Popup_OnImage = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Popup_OnImage_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Popup_OnImage_Fluid_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Popup_OnImage_Fluid_Light = null;
    public static final com.obric.oui.material.c OUI_Bg_Popup_OnImage_Frost_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Popup_OnImage_Frost_Light = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Popup_OnImage_Light = null;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c[]> OUI_Bg_Popup_Overlay = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Popup_Overlay_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Popup_Overlay_Fluid_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Popup_Overlay_Fluid_Light = null;
    public static final com.obric.oui.material.c OUI_Bg_Popup_Overlay_Frost_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Popup_Overlay_Frost_Light = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Popup_Overlay_Light = null;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c[]> OUI_Bg_Scrim = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Scrim_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Scrim_Fluid_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Scrim_Fluid_Light = null;
    public static final com.obric.oui.material.c OUI_Bg_Scrim_Frost_Dark = null;
    public static final com.obric.oui.material.c OUI_Bg_Scrim_Frost_Light = null;
    public static final com.obric.oui.material.c[] OUI_Bg_Scrim_Light = null;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c> OUI_Text_Primary = null;
    public static final com.obric.oui.material.c OUI_Text_Primary_Dark = null;
    public static final com.obric.oui.material.c OUI_Text_Primary_Light = null;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c> OUI_Text_Secondary = null;
    public static final com.obric.oui.material.c OUI_Text_Secondary_Dark = null;
    public static final com.obric.oui.material.c OUI_Text_Secondary_Light = null;
    public static final d.h.a.b<Boolean, com.obric.oui.material.c> OUI_Text_Tertiary = null;
    public static final com.obric.oui.material.c OUI_Text_Tertiary_Dark = null;
    public static final com.obric.oui.material.c OUI_Text_Tertiary_Light = null;
    private static final d.f providers$delegate = null;
    private static final d.f setProviders$delegate = null;
    private static final d.f tokenSets$delegate = null;
    private static final d.f tokens$delegate = null;

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class a extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f35452a = null;

        static {
            f35452a = new a();
        }

        a() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c[] a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Bg_Floating_Light;
        L5:
            return MaterialToken.OUI_Bg_Floating_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class b extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f35453a = null;

        static {
            f35453a = new b();
        }

        b() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c[] a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Bg_Floating_Blue_Light;
        L5:
            return MaterialToken.OUI_Bg_Floating_Blue_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class c extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f35454a = null;

        static {
            f35454a = new c();
        }

        c() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c[] a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Bg_Floating_Fill_Light;
        L5:
            return MaterialToken.OUI_Bg_Floating_Fill_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class d extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f35455a = null;

        static {
            f35455a = new d();
        }

        d() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c[] a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Bg_Floating_OnImage_Light;
        L5:
            return MaterialToken.OUI_Bg_Floating_OnImage_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class e extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f35456a = null;

        static {
            f35456a = new e();
        }

        e() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c[] a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Bg_Floating_Overlay_Light;
        L5:
            return MaterialToken.OUI_Bg_Floating_Overlay_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class f extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f35457a = null;

        static {
            f35457a = new f();
        }

        f() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c[] a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Bg_Floating_Ring_Light;
        L5:
            return MaterialToken.OUI_Bg_Floating_Ring_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class g extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f35458a = null;

        static {
            f35458a = new g();
        }

        g() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c[] a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Bg_Floating_Tinted_Light;
        L5:
            return MaterialToken.OUI_Bg_Floating_Tinted_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class h extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f35459a = null;

        static {
            f35459a = new h();
        }

        h() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c[] a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Bg_Modal_Light;
        L5:
            return MaterialToken.OUI_Bg_Modal_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class i extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f35460a = null;

        static {
            f35460a = new i();
        }

        i() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c[] a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Bg_Overlay_Search_Light;
        L5:
            return MaterialToken.OUI_Bg_Overlay_Search_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class j extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f35461a = null;

        static {
            f35461a = new j();
        }

        j() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c[] a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Bg_Popup_Light;
        L5:
            return MaterialToken.OUI_Bg_Popup_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class k extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f35462a = null;

        static {
            f35462a = new k();
        }

        k() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Bg_Popup_Frost_Light;
        L5:
            return MaterialToken.OUI_Bg_Popup_Frost_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class l extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f35463a = null;

        static {
            f35463a = new l();
        }

        l() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c[] a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Bg_Popup_OnImage_Light;
        L5:
            return MaterialToken.OUI_Bg_Popup_OnImage_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class m extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f35464a = null;

        static {
            f35464a = new m();
        }

        m() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c[] a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Bg_Popup_Overlay_Light;
        L5:
            return MaterialToken.OUI_Bg_Popup_Overlay_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class n extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f35465a = null;

        static {
            f35465a = new n();
        }

        n() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c[] a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Bg_Scrim_Light;
        L5:
            return MaterialToken.OUI_Bg_Scrim_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class o extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f35466a = null;

        static {
            f35466a = new o();
        }

        o() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Text_Primary_Light;
        L5:
            return MaterialToken.OUI_Text_Primary_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class p extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f35467a = null;

        static {
            f35467a = new p();
        }

        p() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Text_Secondary_Light;
        L5:
            return MaterialToken.OUI_Text_Secondary_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class q extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f35468a = null;

        static {
            f35468a = new q();
        }

        q() {
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }

        public final com.obric.oui.material.c a(boolean r1) {
            if (r1 == false) goto L5;
            return MaterialToken.OUI_Text_Tertiary_Light;
        L5:
            return MaterialToken.OUI_Text_Tertiary_Dark;
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    /* synthetic */ class r extends d.h.b.l implements d.h.a.b<com.obric.oui.material.c, com.obric.oui.material.c> {
        r(Object r8) {
            super(1, r8, MaterialToken.class, "compatibleConfig", "compatibleConfig(Lcom/obric/oui/material/MaterialConfig;)Lcom/obric/oui/material/MaterialConfig;", 0);
        }

        public final com.obric.oui.material.c a(com.obric.oui.material.c r1) {
            return MaterialToken.compatibleConfig(r1);
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c invoke(com.obric.oui.material.c r3) {
            return a((com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.material.c.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class s extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<Boolean, com.obric.oui.material.c> f35469a;

        s(d.h.a.b<? super Boolean, com.obric.oui.material.c> r3) {
            this.f35469a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            super(1);
        }

        public final com.obric.oui.material.c a(boolean r4) {
            com.obric.oui.material.c r0 = MaterialToken.compatibleConfig((com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(this.f35469a.invoke(Boolean.valueOf(r4)), com.obric.oui.material.c.class, "com.obric.aiagent.plugin"));
            if (r0 == null) goto L5;
            return r0;
        L5:
            return ((com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(this.f35469a.invoke(Boolean.valueOf(r4)), com.obric.oui.material.c.class, "com.obric.aiagent.plugin")).l();
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class t extends d.h.b.p implements d.h.a.b<Boolean, com.obric.oui.material.c[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<Boolean, com.obric.oui.material.c[]> f35470a;

        t(d.h.a.b<? super Boolean, com.obric.oui.material.c[]> r3) {
            this.f35470a = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            super(1);
        }

        public final com.obric.oui.material.c[] a(boolean r7) {
            com.obric.oui.material.c[] r0 = MaterialToken.compatibleConfigArray((com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(this.f35470a.invoke(Boolean.valueOf(r7)), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin"));
            if (r0 != null) goto L10;
            Object[] r6 = (Object[]) ZeusTransformUtils.preCheckCast(this.f35470a.invoke(Boolean.valueOf(r7)), Object[].class, "com.obric.aiagent.plugin");
            Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r6.length), Collection.class, "com.obric.aiagent.plugin");
            int r1 = r6.length;
            int r3 = 0;
        L5:
            if (r3 >= r1) goto L7;
            r8.add(((com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(r6[r3], com.obric.oui.material.c.class, "com.obric.aiagent.plugin")).l());
            r3 = r3 + 1;
            goto L5
        L7:
            Object[] r9 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new com.obric.oui.material.c[0]);
            Objects.requireNonNull(r9, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(r9, com.obric.oui.material.c[].class, "com.obric.aiagent.plugin");
        L10:
            return r0;
        }

        @Override // d.h.a.b
        public /* synthetic */ com.obric.oui.material.c[] invoke(Boolean r3) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class u extends d.h.b.p implements d.h.a.a<ConcurrentHashMap<String, d.h.a.b<? super Boolean, ? extends com.obric.oui.material.c>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u f35471a = null;

        static {
            f35471a = new u();
        }

        u() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ConcurrentHashMap<String, d.h.a.b<? super Boolean, ? extends com.obric.oui.material.c>> invoke() {
            return a();
        }

        public final ConcurrentHashMap<String, d.h.a.b<Boolean, com.obric.oui.material.c>> a() {
            ConcurrentHashMap<String, d.h.a.b<Boolean, com.obric.oui.material.c>> r11 = new ConcurrentHashMap();
            com.obric.oui.material.n r0 = com.obric.oui.material.n.f35506a;
            MaterialToken r1 = MaterialToken.INSTANCE;
            Map<? extends String, ? extends d.h.a.b<Boolean, com.obric.oui.material.c>> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            Field[] r3 = r1.getClass().getDeclaredFields();     // Catch: Exception -> L11
            d.h.b.o.c(r3, "fields");     // Catch: Exception -> L11
            int r5 = 0;
            int r6 = r3.length;     // Catch: Exception -> L11
        L4:
            if (r5 >= r6) goto L13;
            Field r7 = r3[r5];     // Catch: Exception -> L11
            r5 = r5 + 1;     // Catch: Exception -> L11
            if (d.h.a.b.class.isAssignableFrom(r7.getType()) == false) goto L4;
            r7.setAccessible(true);     // Catch: Exception -> L11
            Object r9 = r7.get(r1);     // Catch: Exception -> L11
            if (ae.a(r9, 1) == false) goto L4;
            String r8 = r7.getName();     // Catch: Exception -> L11
            d.h.b.o.c(r8, "field.name");     // Catch: Exception -> L11
            Locale r10 = Locale.ROOT;     // Catch: Exception -> L11
            d.h.b.o.c(r10, "ROOT");     // Catch: Exception -> L11
            String r12 = r8.toLowerCase(r10);     // Catch: Exception -> L11
            d.h.b.o.c(r12, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
            d.h.b.o.c(r9, "value");     // Catch: Exception -> L11
            r2.put(r12, r9);     // Catch: Exception -> L11
        L13:
            r11.putAll(r2);
            return r11;
        L11:
            e = move-exception;
            a("TokenParser", d.h.b.o.a("Failed to parse tokens from ", r1.getClass().getSimpleName()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L13
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class v extends d.h.b.p implements d.h.a.a<ConcurrentHashMap<String, d.h.a.b<? super Boolean, ? extends com.obric.oui.material.c[]>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f35472a = null;

        static {
            f35472a = new v();
        }

        v() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ConcurrentHashMap<String, d.h.a.b<? super Boolean, ? extends com.obric.oui.material.c[]>> invoke() {
            return a();
        }

        public final ConcurrentHashMap<String, d.h.a.b<Boolean, com.obric.oui.material.c[]>> a() {
            ConcurrentHashMap<String, d.h.a.b<Boolean, com.obric.oui.material.c[]>> r11 = new ConcurrentHashMap();
            com.obric.oui.material.n r0 = com.obric.oui.material.n.f35506a;
            MaterialToken r1 = MaterialToken.INSTANCE;
            Map<? extends String, ? extends d.h.a.b<Boolean, com.obric.oui.material.c[]>> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            Field[] r3 = r1.getClass().getDeclaredFields();     // Catch: Exception -> L11
            d.h.b.o.c(r3, "fields");     // Catch: Exception -> L11
            int r5 = 0;
            int r6 = r3.length;     // Catch: Exception -> L11
        L4:
            if (r5 >= r6) goto L13;
            Field r7 = r3[r5];     // Catch: Exception -> L11
            r5 = r5 + 1;     // Catch: Exception -> L11
            if (d.h.a.b.class.isAssignableFrom(r7.getType()) == false) goto L4;
            r7.setAccessible(true);     // Catch: Exception -> L11
            Object r9 = r7.get(r1);     // Catch: Exception -> L11
            if (ae.a(r9, 1) == false) goto L4;
            String r8 = r7.getName();     // Catch: Exception -> L11
            d.h.b.o.c(r8, "field.name");     // Catch: Exception -> L11
            Locale r10 = Locale.ROOT;     // Catch: Exception -> L11
            d.h.b.o.c(r10, "ROOT");     // Catch: Exception -> L11
            String r12 = r8.toLowerCase(r10);     // Catch: Exception -> L11
            d.h.b.o.c(r12, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
            d.h.b.o.c(r9, "value");     // Catch: Exception -> L11
            r2.put(r12, r9);     // Catch: Exception -> L11
        L13:
            r11.putAll(r2);
            return r11;
        L11:
            e = move-exception;
            a("TokenParser", d.h.b.o.a("Failed to parse tokens from ", r1.getClass().getSimpleName()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L13
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class w extends d.h.b.p implements d.h.a.a<ConcurrentHashMap<String, com.obric.oui.material.c[]>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final w f35473a = null;

        static {
            f35473a = new w();
        }

        w() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ConcurrentHashMap<String, com.obric.oui.material.c[]> invoke() {
            return a();
        }

        public final ConcurrentHashMap<String, com.obric.oui.material.c[]> a() {
            ConcurrentHashMap<String, com.obric.oui.material.c[]> r11 = new ConcurrentHashMap();
            com.obric.oui.material.n r0 = com.obric.oui.material.n.f35506a;
            MaterialToken r1 = MaterialToken.INSTANCE;
            Map<? extends String, ? extends com.obric.oui.material.c[]> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            Field[] r3 = r1.getClass().getDeclaredFields();     // Catch: Exception -> L11
            d.h.b.o.c(r3, "fields");     // Catch: Exception -> L11
            int r5 = 0;
            int r6 = r3.length;     // Catch: Exception -> L11
        L4:
            if (r5 >= r6) goto L13;
            Field r7 = r3[r5];     // Catch: Exception -> L11
            r5 = r5 + 1;     // Catch: Exception -> L11
            if (com.obric.oui.material.c[].class.isAssignableFrom(r7.getType()) == false) goto L4;
            r7.setAccessible(true);     // Catch: Exception -> L11
            Object r8 = r7.get(r1);     // Catch: Exception -> L11
            if ((r8 instanceof com.obric.oui.material.c[]) == false) goto L4;
            String r9 = r7.getName();     // Catch: Exception -> L11
            d.h.b.o.c(r9, "field.name");     // Catch: Exception -> L11
            Locale r10 = Locale.ROOT;     // Catch: Exception -> L11
            d.h.b.o.c(r10, "ROOT");     // Catch: Exception -> L11
            String r12 = r9.toLowerCase(r10);     // Catch: Exception -> L11
            d.h.b.o.c(r12, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
            r2.put(r12, r8);     // Catch: Exception -> L11
        L13:
            r11.putAll(r2);
            return r11;
        L11:
            e = move-exception;
            a("TokenParser", d.h.b.o.a("Failed to parse tokens from ", r1.getClass().getSimpleName()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L13
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: MaterialToken.kt */
    static final class x extends d.h.b.p implements d.h.a.a<ConcurrentHashMap<String, com.obric.oui.material.c>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final x f35474a = null;

        static {
            f35474a = new x();
        }

        x() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ ConcurrentHashMap<String, com.obric.oui.material.c> invoke() {
            return a();
        }

        public final ConcurrentHashMap<String, com.obric.oui.material.c> a() {
            ConcurrentHashMap<String, com.obric.oui.material.c> r11 = new ConcurrentHashMap();
            com.obric.oui.material.n r0 = com.obric.oui.material.n.f35506a;
            MaterialToken r1 = MaterialToken.INSTANCE;
            Map<? extends String, ? extends com.obric.oui.material.c> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            Field[] r3 = r1.getClass().getDeclaredFields();     // Catch: Exception -> L11
            d.h.b.o.c(r3, "fields");     // Catch: Exception -> L11
            int r5 = 0;
            int r6 = r3.length;     // Catch: Exception -> L11
        L4:
            if (r5 >= r6) goto L13;
            Field r7 = r3[r5];     // Catch: Exception -> L11
            r5 = r5 + 1;     // Catch: Exception -> L11
            if (com.obric.oui.material.c.class.isAssignableFrom(r7.getType()) == false) goto L4;
            r7.setAccessible(true);     // Catch: Exception -> L11
            Object r8 = r7.get(r1);     // Catch: Exception -> L11
            if (ZeusTransformUtils.instanceOf(r8, com.obric.oui.material.c.class) == false) goto L4;
            String r9 = r7.getName();     // Catch: Exception -> L11
            d.h.b.o.c(r9, "field.name");     // Catch: Exception -> L11
            Locale r10 = Locale.ROOT;     // Catch: Exception -> L11
            d.h.b.o.c(r10, "ROOT");     // Catch: Exception -> L11
            String r12 = r9.toLowerCase(r10);     // Catch: Exception -> L11
            d.h.b.o.c(r12, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
            r2.put(r12, r8);     // Catch: Exception -> L11
        L13:
            r11.putAll(r2);
            return r11;
        L11:
            e = move-exception;
            a("TokenParser", d.h.b.o.a("Failed to parse tokens from ", r1.getClass().getSimpleName()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L13
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static /* synthetic */ void getOUI_Bg_Overlay_Search$annotations() {
    }

    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Dark$annotations() {
    }

    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Fluid_Dark$annotations() {
    }

    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Fluid_Light$annotations() {
    }

    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Frost_Dark$annotations() {
    }

    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Frost_Light$annotations() {
    }

    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Light$annotations() {
    }

    private MaterialToken() {
    }

    static {
        INSTANCE = new MaterialToken();
        tokens$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(x.f35474a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        tokenSets$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(w.f35473a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        providers$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(u.f35471a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        setProviders$delegate = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(v.f35472a, d.h.a.a.class, "com.obric.aiagent.plugin"));
        com.obric.oui.material.e r0 = MaterialTokenCore.OUI_Bg_Floating_Frost_Light;
        d.h.b.o.c(r0, "OUI_Bg_Floating_Frost_Light");
        OUI_Bg_Floating_Frost_Light = com.obric.oui.material.f.a(r0);
        com.obric.oui.material.e r1 = MaterialTokenCore.OUI_Bg_Floating_Frost_Dark;
        d.h.b.o.c(r1, "OUI_Bg_Floating_Frost_Dark");
        OUI_Bg_Floating_Frost_Dark = com.obric.oui.material.f.a(r1);
        com.obric.oui.material.e r2 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Light;
        d.h.b.o.c(r2, "OUI_Bg_Floating_Fluid_Light");
        OUI_Bg_Floating_Fluid_Light = com.obric.oui.material.f.a(r2);
        com.obric.oui.material.e r3 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Dark;
        d.h.b.o.c(r3, "OUI_Bg_Floating_Fluid_Dark");
        OUI_Bg_Floating_Fluid_Dark = com.obric.oui.material.f.a(r3);
        com.obric.oui.material.e[] r4 = MaterialTokenCore.OUI_Bg_Floating_Light;
        d.h.b.o.c(r4, "OUI_Bg_Floating_Light");
        OUI_Bg_Floating_Light = com.obric.oui.material.f.a(r4);
        com.obric.oui.material.e[] r5 = MaterialTokenCore.OUI_Bg_Floating_Dark;
        d.h.b.o.c(r5, "OUI_Bg_Floating_Dark");
        OUI_Bg_Floating_Dark = com.obric.oui.material.f.a(r5);
        OUI_Bg_Floating = (d.h.a.b) ZeusTransformUtils.preCheckCast(a.f35452a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.e r6 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Frost_Light;
        d.h.b.o.c(r6, "OUI_Bg_Floating_OnImage_Frost_Light");
        OUI_Bg_Floating_OnImage_Frost_Light = com.obric.oui.material.f.a(r6);
        com.obric.oui.material.e r7 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Frost_Dark;
        d.h.b.o.c(r7, "OUI_Bg_Floating_OnImage_Frost_Dark");
        OUI_Bg_Floating_OnImage_Frost_Dark = com.obric.oui.material.f.a(r7);
        com.obric.oui.material.e r8 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Fluid_Light;
        d.h.b.o.c(r8, "OUI_Bg_Floating_OnImage_Fluid_Light");
        OUI_Bg_Floating_OnImage_Fluid_Light = com.obric.oui.material.f.a(r8);
        com.obric.oui.material.e r9 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Fluid_Dark;
        d.h.b.o.c(r9, "OUI_Bg_Floating_OnImage_Fluid_Dark");
        OUI_Bg_Floating_OnImage_Fluid_Dark = com.obric.oui.material.f.a(r9);
        com.obric.oui.material.e[] r10 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Light;
        d.h.b.o.c(r10, "OUI_Bg_Floating_OnImage_Light");
        OUI_Bg_Floating_OnImage_Light = com.obric.oui.material.f.a(r10);
        com.obric.oui.material.e[] r11 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Dark;
        d.h.b.o.c(r11, "OUI_Bg_Floating_OnImage_Dark");
        OUI_Bg_Floating_OnImage_Dark = com.obric.oui.material.f.a(r11);
        OUI_Bg_Floating_OnImage = (d.h.a.b) ZeusTransformUtils.preCheckCast(d.f35455a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.e r12 = MaterialTokenCore.OUI_Bg_Floating_Fill_Frost_Light;
        d.h.b.o.c(r12, "OUI_Bg_Floating_Fill_Frost_Light");
        OUI_Bg_Floating_Fill_Frost_Light = com.obric.oui.material.f.a(r12);
        com.obric.oui.material.e r13 = MaterialTokenCore.OUI_Bg_Floating_Fill_Frost_Dark;
        d.h.b.o.c(r13, "OUI_Bg_Floating_Fill_Frost_Dark");
        OUI_Bg_Floating_Fill_Frost_Dark = com.obric.oui.material.f.a(r13);
        com.obric.oui.material.e r14 = MaterialTokenCore.OUI_Bg_Floating_Fill_Fluid_Light;
        d.h.b.o.c(r14, "OUI_Bg_Floating_Fill_Fluid_Light");
        OUI_Bg_Floating_Fill_Fluid_Light = com.obric.oui.material.f.a(r14);
        com.obric.oui.material.e r15 = MaterialTokenCore.OUI_Bg_Floating_Fill_Fluid_Dark;
        d.h.b.o.c(r15, "OUI_Bg_Floating_Fill_Fluid_Dark");
        OUI_Bg_Floating_Fill_Fluid_Dark = com.obric.oui.material.f.a(r15);
        com.obric.oui.material.e[] r16 = MaterialTokenCore.OUI_Bg_Floating_Fill_Light;
        d.h.b.o.c(r16, "OUI_Bg_Floating_Fill_Light");
        OUI_Bg_Floating_Fill_Light = com.obric.oui.material.f.a(r16);
        com.obric.oui.material.e[] r17 = MaterialTokenCore.OUI_Bg_Floating_Fill_Dark;
        d.h.b.o.c(r17, "OUI_Bg_Floating_Fill_Dark");
        OUI_Bg_Floating_Fill_Dark = com.obric.oui.material.f.a(r17);
        OUI_Bg_Floating_Fill = (d.h.a.b) ZeusTransformUtils.preCheckCast(c.f35454a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.e r18 = MaterialTokenCore.OUI_Bg_Popup_Frost_Light;
        d.h.b.o.c(r18, "OUI_Bg_Popup_Frost_Light");
        OUI_Bg_Popup_Frost_Light = com.obric.oui.material.f.a(r18);
        com.obric.oui.material.e r19 = MaterialTokenCore.OUI_Bg_Popup_Frost_Dark;
        d.h.b.o.c(r19, "OUI_Bg_Popup_Frost_Dark");
        OUI_Bg_Popup_Frost_Dark = com.obric.oui.material.f.a(r19);
        OUI_Bg_Popup_Frost = (d.h.a.b) ZeusTransformUtils.preCheckCast(k.f35462a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.e r20 = MaterialTokenCore.OUI_Bg_Popup_Fluid_Light;
        d.h.b.o.c(r20, "OUI_Bg_Popup_Fluid_Light");
        OUI_Bg_Popup_Fluid_Light = com.obric.oui.material.f.a(r20);
        com.obric.oui.material.e r21 = MaterialTokenCore.OUI_Bg_Popup_Fluid_Dark;
        d.h.b.o.c(r21, "OUI_Bg_Popup_Fluid_Dark");
        OUI_Bg_Popup_Fluid_Dark = com.obric.oui.material.f.a(r21);
        com.obric.oui.material.e[] r22 = MaterialTokenCore.OUI_Bg_Popup_Light;
        d.h.b.o.c(r22, "OUI_Bg_Popup_Light");
        OUI_Bg_Popup_Light = com.obric.oui.material.f.a(r22);
        com.obric.oui.material.e[] r23 = MaterialTokenCore.OUI_Bg_Popup_Dark;
        d.h.b.o.c(r23, "OUI_Bg_Popup_Dark");
        OUI_Bg_Popup_Dark = com.obric.oui.material.f.a(r23);
        OUI_Bg_Popup = (d.h.a.b) ZeusTransformUtils.preCheckCast(j.f35461a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.e r24 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Frost_Light;
        d.h.b.o.c(r24, "OUI_Bg_Popup_OnImage_Frost_Light");
        OUI_Bg_Popup_OnImage_Frost_Light = com.obric.oui.material.f.a(r24);
        com.obric.oui.material.e r25 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Frost_Dark;
        d.h.b.o.c(r25, "OUI_Bg_Popup_OnImage_Frost_Dark");
        OUI_Bg_Popup_OnImage_Frost_Dark = com.obric.oui.material.f.a(r25);
        com.obric.oui.material.e r26 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Fluid_Light;
        d.h.b.o.c(r26, "OUI_Bg_Popup_OnImage_Fluid_Light");
        OUI_Bg_Popup_OnImage_Fluid_Light = com.obric.oui.material.f.a(r26);
        com.obric.oui.material.e r27 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Fluid_Dark;
        d.h.b.o.c(r27, "OUI_Bg_Popup_OnImage_Fluid_Dark");
        OUI_Bg_Popup_OnImage_Fluid_Dark = com.obric.oui.material.f.a(r27);
        com.obric.oui.material.e[] r28 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Light;
        d.h.b.o.c(r28, "OUI_Bg_Popup_OnImage_Light");
        OUI_Bg_Popup_OnImage_Light = com.obric.oui.material.f.a(r28);
        com.obric.oui.material.e[] r29 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Dark;
        d.h.b.o.c(r29, "OUI_Bg_Popup_OnImage_Dark");
        OUI_Bg_Popup_OnImage_Dark = com.obric.oui.material.f.a(r29);
        OUI_Bg_Popup_OnImage = (d.h.a.b) ZeusTransformUtils.preCheckCast(l.f35463a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.e r30 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Frost_Light;
        d.h.b.o.c(r30, "OUI_Bg_Popup_Overlay_Frost_Light");
        OUI_Bg_Popup_Overlay_Frost_Light = com.obric.oui.material.f.a(r30);
        com.obric.oui.material.e r31 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Frost_Dark;
        d.h.b.o.c(r31, "OUI_Bg_Popup_Overlay_Frost_Dark");
        OUI_Bg_Popup_Overlay_Frost_Dark = com.obric.oui.material.f.a(r31);
        com.obric.oui.material.e r32 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Fluid_Light;
        d.h.b.o.c(r32, "OUI_Bg_Popup_Overlay_Fluid_Light");
        OUI_Bg_Popup_Overlay_Fluid_Light = com.obric.oui.material.f.a(r32);
        com.obric.oui.material.e r33 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Fluid_Dark;
        d.h.b.o.c(r33, "OUI_Bg_Popup_Overlay_Fluid_Dark");
        OUI_Bg_Popup_Overlay_Fluid_Dark = com.obric.oui.material.f.a(r33);
        com.obric.oui.material.e[] r34 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Light;
        d.h.b.o.c(r34, "OUI_Bg_Popup_Overlay_Light");
        OUI_Bg_Popup_Overlay_Light = com.obric.oui.material.f.a(r34);
        com.obric.oui.material.e[] r35 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Dark;
        d.h.b.o.c(r35, "OUI_Bg_Popup_Overlay_Dark");
        OUI_Bg_Popup_Overlay_Dark = com.obric.oui.material.f.a(r35);
        OUI_Bg_Popup_Overlay = (d.h.a.b) ZeusTransformUtils.preCheckCast(m.f35464a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.e r36 = MaterialTokenCore.OUI_Bg_Modal_Frost_Light;
        d.h.b.o.c(r36, "OUI_Bg_Modal_Frost_Light");
        OUI_Bg_Modal_Frost_Light = com.obric.oui.material.f.a(r36);
        com.obric.oui.material.e r37 = MaterialTokenCore.OUI_Bg_Modal_Frost_Dark;
        d.h.b.o.c(r37, "OUI_Bg_Modal_Frost_Dark");
        OUI_Bg_Modal_Frost_Dark = com.obric.oui.material.f.a(r37);
        com.obric.oui.material.e r38 = MaterialTokenCore.OUI_Bg_Modal_Fluid_Light;
        d.h.b.o.c(r38, "OUI_Bg_Modal_Fluid_Light");
        OUI_Bg_Modal_Fluid_Light = com.obric.oui.material.f.a(r38);
        com.obric.oui.material.e r39 = MaterialTokenCore.OUI_Bg_Modal_Fluid_Dark;
        d.h.b.o.c(r39, "OUI_Bg_Modal_Fluid_Dark");
        OUI_Bg_Modal_Fluid_Dark = com.obric.oui.material.f.a(r39);
        com.obric.oui.material.e[] r40 = MaterialTokenCore.OUI_Bg_Modal_Light;
        d.h.b.o.c(r40, "OUI_Bg_Modal_Light");
        OUI_Bg_Modal_Light = com.obric.oui.material.f.a(r40);
        com.obric.oui.material.e[] r41 = MaterialTokenCore.OUI_Bg_Modal_Dark;
        d.h.b.o.c(r41, "OUI_Bg_Modal_Dark");
        OUI_Bg_Modal_Dark = com.obric.oui.material.f.a(r41);
        OUI_Bg_Modal = (d.h.a.b) ZeusTransformUtils.preCheckCast(h.f35459a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.e r42 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Frost_Light;
        d.h.b.o.c(r42, "OUI_Bg_Floating_Overlay_Frost_Light");
        OUI_Bg_Floating_Overlay_Frost_Light = com.obric.oui.material.f.a(r42);
        com.obric.oui.material.e r43 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Frost_Dark;
        d.h.b.o.c(r43, "OUI_Bg_Floating_Overlay_Frost_Dark");
        OUI_Bg_Floating_Overlay_Frost_Dark = com.obric.oui.material.f.a(r43);
        com.obric.oui.material.e r44 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Fluid_Light;
        d.h.b.o.c(r44, "OUI_Bg_Floating_Overlay_Fluid_Light");
        OUI_Bg_Floating_Overlay_Fluid_Light = com.obric.oui.material.f.a(r44);
        com.obric.oui.material.e r45 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Fluid_Dark;
        d.h.b.o.c(r45, "OUI_Bg_Floating_Overlay_Fluid_Dark");
        OUI_Bg_Floating_Overlay_Fluid_Dark = com.obric.oui.material.f.a(r45);
        com.obric.oui.material.e[] r46 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Light;
        d.h.b.o.c(r46, "OUI_Bg_Floating_Overlay_Light");
        OUI_Bg_Floating_Overlay_Light = com.obric.oui.material.f.a(r46);
        com.obric.oui.material.e[] r47 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Dark;
        d.h.b.o.c(r47, "OUI_Bg_Floating_Overlay_Dark");
        OUI_Bg_Floating_Overlay_Dark = com.obric.oui.material.f.a(r47);
        OUI_Bg_Floating_Overlay = (d.h.a.b) ZeusTransformUtils.preCheckCast(e.f35456a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.e r48 = MaterialTokenCore.OUI_Bg_Scrim_Frost_Light;
        d.h.b.o.c(r48, "OUI_Bg_Scrim_Frost_Light");
        OUI_Bg_Scrim_Frost_Light = com.obric.oui.material.f.a(r48);
        com.obric.oui.material.e r49 = MaterialTokenCore.OUI_Bg_Scrim_Frost_Dark;
        d.h.b.o.c(r49, "OUI_Bg_Scrim_Frost_Dark");
        OUI_Bg_Scrim_Frost_Dark = com.obric.oui.material.f.a(r49);
        com.obric.oui.material.e r50 = MaterialTokenCore.OUI_Bg_Scrim_Fluid_Light;
        d.h.b.o.c(r50, "OUI_Bg_Scrim_Fluid_Light");
        OUI_Bg_Scrim_Fluid_Light = com.obric.oui.material.f.a(r50);
        com.obric.oui.material.e r51 = MaterialTokenCore.OUI_Bg_Scrim_Fluid_Dark;
        d.h.b.o.c(r51, "OUI_Bg_Scrim_Fluid_Dark");
        OUI_Bg_Scrim_Fluid_Dark = com.obric.oui.material.f.a(r51);
        com.obric.oui.material.e[] r52 = MaterialTokenCore.OUI_Bg_Scrim_Light;
        d.h.b.o.c(r52, "OUI_Bg_Scrim_Light");
        OUI_Bg_Scrim_Light = com.obric.oui.material.f.a(r52);
        com.obric.oui.material.e[] r53 = MaterialTokenCore.OUI_Bg_Scrim_Dark;
        d.h.b.o.c(r53, "OUI_Bg_Scrim_Dark");
        OUI_Bg_Scrim_Dark = com.obric.oui.material.f.a(r53);
        OUI_Bg_Scrim = (d.h.a.b) ZeusTransformUtils.preCheckCast(n.f35465a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.e r54 = MaterialTokenCore.OUI_Bg_Floating_Ring_Frost_Light;
        d.h.b.o.c(r54, "OUI_Bg_Floating_Ring_Frost_Light");
        OUI_Bg_Floating_Ring_Frost_Light = com.obric.oui.material.f.a(r54);
        com.obric.oui.material.e r55 = MaterialTokenCore.OUI_Bg_Floating_Ring_Frost_Dark;
        d.h.b.o.c(r55, "OUI_Bg_Floating_Ring_Frost_Dark");
        OUI_Bg_Floating_Ring_Frost_Dark = com.obric.oui.material.f.a(r55);
        com.obric.oui.material.e r56 = MaterialTokenCore.OUI_Bg_Floating_Ring_Fluid_Light;
        d.h.b.o.c(r56, "OUI_Bg_Floating_Ring_Fluid_Light");
        OUI_Bg_Floating_Ring_Fluid_Light = com.obric.oui.material.f.a(r56);
        com.obric.oui.material.e r57 = MaterialTokenCore.OUI_Bg_Floating_Ring_Fluid_Dark;
        d.h.b.o.c(r57, "OUI_Bg_Floating_Ring_Fluid_Dark");
        OUI_Bg_Floating_Ring_Fluid_Dark = com.obric.oui.material.f.a(r57);
        com.obric.oui.material.e[] r58 = MaterialTokenCore.OUI_Bg_Floating_Ring_Light;
        d.h.b.o.c(r58, "OUI_Bg_Floating_Ring_Light");
        OUI_Bg_Floating_Ring_Light = com.obric.oui.material.f.a(r58);
        com.obric.oui.material.e[] r59 = MaterialTokenCore.OUI_Bg_Floating_Ring_Dark;
        d.h.b.o.c(r59, "OUI_Bg_Floating_Ring_Dark");
        OUI_Bg_Floating_Ring_Dark = com.obric.oui.material.f.a(r59);
        OUI_Bg_Floating_Ring = (d.h.a.b) ZeusTransformUtils.preCheckCast(f.f35457a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.e r60 = MaterialTokenCore.OUI_Bg_Overlay_Search_Frost_Light;
        d.h.b.o.c(r60, "OUI_Bg_Overlay_Search_Frost_Light");
        OUI_Bg_Overlay_Search_Frost_Light = com.obric.oui.material.f.a(r60);
        com.obric.oui.material.e r61 = MaterialTokenCore.OUI_Bg_Overlay_Search_Frost_Dark;
        d.h.b.o.c(r61, "OUI_Bg_Overlay_Search_Frost_Dark");
        OUI_Bg_Overlay_Search_Frost_Dark = com.obric.oui.material.f.a(r61);
        com.obric.oui.material.e r62 = MaterialTokenCore.OUI_Bg_Overlay_Search_Fluid_Light;
        d.h.b.o.c(r62, "OUI_Bg_Overlay_Search_Fluid_Light");
        OUI_Bg_Overlay_Search_Fluid_Light = com.obric.oui.material.f.a(r62);
        com.obric.oui.material.e r63 = MaterialTokenCore.OUI_Bg_Overlay_Search_Fluid_Dark;
        d.h.b.o.c(r63, "OUI_Bg_Overlay_Search_Fluid_Dark");
        OUI_Bg_Overlay_Search_Fluid_Dark = com.obric.oui.material.f.a(r63);
        com.obric.oui.material.e[] r64 = MaterialTokenCore.OUI_Bg_Overlay_Search_Light;
        d.h.b.o.c(r64, "OUI_Bg_Overlay_Search_Light");
        OUI_Bg_Overlay_Search_Light = com.obric.oui.material.f.a(r64);
        com.obric.oui.material.e[] r65 = MaterialTokenCore.OUI_Bg_Overlay_Search_Dark;
        d.h.b.o.c(r65, "OUI_Bg_Overlay_Search_Dark");
        OUI_Bg_Overlay_Search_Dark = com.obric.oui.material.f.a(r65);
        OUI_Bg_Overlay_Search = (d.h.a.b) ZeusTransformUtils.preCheckCast(i.f35460a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.e r66 = MaterialTokenCore.OUI_Bg_Floating_Frost_Tinted_Light;
        d.h.b.o.c(r66, "OUI_Bg_Floating_Frost_Tinted_Light");
        OUI_Bg_Floating_Frost_Tinted_Light = com.obric.oui.material.f.a(r66);
        com.obric.oui.material.e r67 = MaterialTokenCore.OUI_Bg_Floating_Frost_Tinted_Dark;
        d.h.b.o.c(r67, "OUI_Bg_Floating_Frost_Tinted_Dark");
        OUI_Bg_Floating_Frost_Tinted_Dark = com.obric.oui.material.f.a(r67);
        com.obric.oui.material.e r68 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Tinted_Light;
        d.h.b.o.c(r68, "OUI_Bg_Floating_Fluid_Tinted_Light");
        OUI_Bg_Floating_Fluid_Tinted_Light = com.obric.oui.material.f.a(r68);
        com.obric.oui.material.e r69 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Tinted_Dark;
        d.h.b.o.c(r69, "OUI_Bg_Floating_Fluid_Tinted_Dark");
        OUI_Bg_Floating_Fluid_Tinted_Dark = com.obric.oui.material.f.a(r69);
        com.obric.oui.material.e[] r70 = MaterialTokenCore.OUI_Bg_Floating_Tinted_Light;
        d.h.b.o.c(r70, "OUI_Bg_Floating_Tinted_Light");
        OUI_Bg_Floating_Tinted_Light = com.obric.oui.material.f.a(r70);
        com.obric.oui.material.e[] r71 = MaterialTokenCore.OUI_Bg_Floating_Tinted_Dark;
        d.h.b.o.c(r71, "OUI_Bg_Floating_Tinted_Dark");
        OUI_Bg_Floating_Tinted_Dark = com.obric.oui.material.f.a(r71);
        OUI_Bg_Floating_Tinted = (d.h.a.b) ZeusTransformUtils.preCheckCast(g.f35458a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.e r72 = MaterialTokenCore.OUI_Bg_Floating_Frost_Blue_Light;
        d.h.b.o.c(r72, "OUI_Bg_Floating_Frost_Blue_Light");
        OUI_Bg_Floating_Frost_Blue_Light = com.obric.oui.material.f.a(r72);
        com.obric.oui.material.e r73 = MaterialTokenCore.OUI_Bg_Floating_Frost_Blue_Dark;
        d.h.b.o.c(r73, "OUI_Bg_Floating_Frost_Blue_Dark");
        OUI_Bg_Floating_Frost_Blue_Dark = com.obric.oui.material.f.a(r73);
        com.obric.oui.material.e r74 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Blue_Light;
        d.h.b.o.c(r74, "OUI_Bg_Floating_Fluid_Blue_Light");
        OUI_Bg_Floating_Fluid_Blue_Light = com.obric.oui.material.f.a(r74);
        com.obric.oui.material.e r75 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Blue_Dark;
        d.h.b.o.c(r75, "OUI_Bg_Floating_Fluid_Blue_Dark");
        OUI_Bg_Floating_Fluid_Blue_Dark = com.obric.oui.material.f.a(r75);
        com.obric.oui.material.e[] r76 = MaterialTokenCore.OUI_Bg_Floating_Blue_Light;
        d.h.b.o.c(r76, "OUI_Bg_Floating_Blue_Light");
        OUI_Bg_Floating_Blue_Light = com.obric.oui.material.f.a(r76);
        com.obric.oui.material.e[] r77 = MaterialTokenCore.OUI_Bg_Floating_Blue_Dark;
        d.h.b.o.c(r77, "OUI_Bg_Floating_Blue_Dark");
        OUI_Bg_Floating_Blue_Dark = com.obric.oui.material.f.a(r77);
        OUI_Bg_Floating_Blue = (d.h.a.b) ZeusTransformUtils.preCheckCast(b.f35453a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.e r78 = MaterialTokenCore.OUI_Text_Primary_Light;
        d.h.b.o.c(r78, "OUI_Text_Primary_Light");
        OUI_Text_Primary_Light = com.obric.oui.material.f.a(r78);
        com.obric.oui.material.e r79 = MaterialTokenCore.OUI_Text_Primary_Dark;
        d.h.b.o.c(r79, "OUI_Text_Primary_Dark");
        OUI_Text_Primary_Dark = com.obric.oui.material.f.a(r79);
        OUI_Text_Primary = (d.h.a.b) ZeusTransformUtils.preCheckCast(o.f35466a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.e r80 = MaterialTokenCore.OUI_Text_Secondary_Light;
        d.h.b.o.c(r80, "OUI_Text_Secondary_Light");
        OUI_Text_Secondary_Light = com.obric.oui.material.f.a(r80);
        com.obric.oui.material.e r81 = MaterialTokenCore.OUI_Text_Secondary_Dark;
        d.h.b.o.c(r81, "OUI_Text_Secondary_Dark");
        OUI_Text_Secondary_Dark = com.obric.oui.material.f.a(r81);
        OUI_Text_Secondary = (d.h.a.b) ZeusTransformUtils.preCheckCast(p.f35467a, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.material.e r82 = MaterialTokenCore.OUI_Text_Tertiary_Light;
        d.h.b.o.c(r82, "OUI_Text_Tertiary_Light");
        OUI_Text_Tertiary_Light = com.obric.oui.material.f.a(r82);
        com.obric.oui.material.e r83 = MaterialTokenCore.OUI_Text_Tertiary_Dark;
        d.h.b.o.c(r83, "OUI_Text_Tertiary_Dark");
        OUI_Text_Tertiary_Dark = com.obric.oui.material.f.a(r83);
        OUI_Text_Tertiary = (d.h.a.b) ZeusTransformUtils.preCheckCast(q.f35468a, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    private final ConcurrentHashMap<String, com.obric.oui.material.c> getTokens() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(tokens$delegate.b(), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
    }

    private final ConcurrentHashMap<String, com.obric.oui.material.c[]> getTokenSets() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(tokenSets$delegate.b(), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
    }

    private final ConcurrentHashMap<String, d.h.a.b<Boolean, com.obric.oui.material.c>> getProviders() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(providers$delegate.b(), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
    }

    private final ConcurrentHashMap<String, d.h.a.b<Boolean, com.obric.oui.material.c[]>> getSetProviders() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(setProviders$delegate.b(), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ void register$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        register(r0, r1);
    }

    public static final void register(Object r2, boolean r3) {
        d.h.b.o.e(r2, "customTokenOwner");
        com.obric.oui.material.o.a(INSTANCE.getTokens(), r2, com.obric.oui.material.c.class, r3);
    }

    public static /* synthetic */ void registerSet$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerSet(r0, r1);
    }

    public static final void registerSet(Object r2, boolean r3) {
        d.h.b.o.e(r2, "customTokenOwner");
        com.obric.oui.material.o.a(INSTANCE.getTokenSets(), r2, com.obric.oui.material.c[].class, r3);
    }

    public static /* synthetic */ void registerTokens$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.aiagent.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerTokens(r5, r2);
    }

    public static final void registerTokens(Map<String, com.obric.oui.material.c> r2, boolean r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "customTokens");
        com.obric.oui.material.o.a(INSTANCE.getTokens(), r4, r3);
    }

    public static /* synthetic */ void registerTokenSets$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.aiagent.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerTokenSets(r5, r2);
    }

    public static final void registerTokenSets(Map<String, com.obric.oui.material.c[]> r2, boolean r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "customTokens");
        com.obric.oui.material.o.a(INSTANCE.getTokenSets(), r4, r3);
    }

    public static /* synthetic */ void registerProvider$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerProvider(r0, r1);
    }

    public static final void registerProvider(Object r12, boolean r13) {
        d.h.b.o.e(r12, "customTokenOwner");
        com.obric.oui.material.n r0 = com.obric.oui.material.n.f35506a;
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getProviders(), Map.class, "com.obric.aiagent.plugin");
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Field[] r5 = r12.getClass().getDeclaredFields();     // Catch: Exception -> L11
        d.h.b.o.c(r5, "fields");     // Catch: Exception -> L11
        int r6 = 0;
        int r7 = r5.length;     // Catch: Exception -> L11
    L4:
        if (r6 >= r7) goto L13;
        Field r8 = r5[r6];     // Catch: Exception -> L11
        r6 = r6 + 1;     // Catch: Exception -> L11
        if (d.h.a.b.class.isAssignableFrom(r8.getType()) == false) goto L4;
        r8.setAccessible(true);     // Catch: Exception -> L11
        Object r10 = r8.get(r12);     // Catch: Exception -> L11
        if (ae.a(r10, 1) == false) goto L4;
        String r9 = r8.getName();     // Catch: Exception -> L11
        d.h.b.o.c(r9, "field.name");     // Catch: Exception -> L11
        Locale r11 = Locale.ROOT;     // Catch: Exception -> L11
        d.h.b.o.c(r11, "ROOT");     // Catch: Exception -> L11
        String r14 = r9.toLowerCase(r11);     // Catch: Exception -> L11
        d.h.b.o.c(r14, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        d.h.b.o.c(r10, "value");     // Catch: Exception -> L11
        r4.put(r14, r10);     // Catch: Exception -> L11
    L13:
        r0.a(r1, r4, r13);
        return;
    L11:
        e = move-exception;
        INVOKESTATIC_com_obric_oui_material_MaterialToken_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("TokenParser", d.h.b.o.a("Failed to parse tokens from ", r12.getClass().getSimpleName()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L13
    }

    public static /* synthetic */ void registerSetProvider$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerSetProvider(r0, r1);
    }

    public static final void registerSetProvider(Object r12, boolean r13) {
        d.h.b.o.e(r12, "customTokenOwner");
        com.obric.oui.material.n r0 = com.obric.oui.material.n.f35506a;
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getSetProviders(), Map.class, "com.obric.aiagent.plugin");
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Field[] r5 = r12.getClass().getDeclaredFields();     // Catch: Exception -> L11
        d.h.b.o.c(r5, "fields");     // Catch: Exception -> L11
        int r6 = 0;
        int r7 = r5.length;     // Catch: Exception -> L11
    L4:
        if (r6 >= r7) goto L13;
        Field r8 = r5[r6];     // Catch: Exception -> L11
        r6 = r6 + 1;     // Catch: Exception -> L11
        if (d.h.a.b.class.isAssignableFrom(r8.getType()) == false) goto L4;
        r8.setAccessible(true);     // Catch: Exception -> L11
        Object r10 = r8.get(r12);     // Catch: Exception -> L11
        if (ae.a(r10, 1) == false) goto L4;
        String r9 = r8.getName();     // Catch: Exception -> L11
        d.h.b.o.c(r9, "field.name");     // Catch: Exception -> L11
        Locale r11 = Locale.ROOT;     // Catch: Exception -> L11
        d.h.b.o.c(r11, "ROOT");     // Catch: Exception -> L11
        String r14 = r9.toLowerCase(r11);     // Catch: Exception -> L11
        d.h.b.o.c(r14, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        d.h.b.o.c(r10, "value");     // Catch: Exception -> L11
        r4.put(r14, r10);     // Catch: Exception -> L11
    L13:
        r0.a(r1, r4, r13);
        return;
    L11:
        e = move-exception;
        INVOKESTATIC_com_obric_oui_material_MaterialToken_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("TokenParser", d.h.b.o.a("Failed to parse tokens from ", r12.getClass().getSimpleName()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L13
    }

    public static /* synthetic */ void registerProviderTokens$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.aiagent.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerProviderTokens(r5, r2);
    }

    public static final void registerProviderTokens(Map<String, ? extends d.h.a.b<? super Boolean, com.obric.oui.material.c>> r4, boolean r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "customTokens");
        com.obric.oui.material.n.f35506a.a((Map) ZeusTransformUtils.preCheckCast(INSTANCE.getProviders(), Map.class, "com.obric.aiagent.plugin"), r6, r5);
    }

    public static /* synthetic */ void registerSetProviderTokens$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.aiagent.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerSetProviderTokens(r5, r2);
    }

    public static final void registerSetProviderTokens(Map<String, ? extends d.h.a.b<? super Boolean, com.obric.oui.material.c[]>> r4, boolean r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "customTokens");
        com.obric.oui.material.n.f35506a.a((Map) ZeusTransformUtils.preCheckCast(INSTANCE.getSetProviders(), Map.class, "com.obric.aiagent.plugin"), r6, r5);
    }

    public static final d.h.a.b<Boolean, com.obric.oui.material.c> parse(String r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.preCheckCast(com.obric.oui.material.o.a(r3, (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getProviders(), Map.class, "com.obric.aiagent.plugin")), d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return (d.h.a.b) ZeusTransformUtils.preCheckCast(new s(r4), d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public static final d.h.a.b<Boolean, com.obric.oui.material.c[]> parseSet(String r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.preCheckCast(com.obric.oui.material.o.a(r3, (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getSetProviders(), Map.class, "com.obric.aiagent.plugin")), d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return (d.h.a.b) ZeusTransformUtils.preCheckCast(new t(r4), d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public static final com.obric.oui.material.c parse(String r4, boolean r5) {
        MaterialToken r0 = INSTANCE;
        com.obric.oui.material.c r1 = (com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(com.obric.oui.material.o.a(r4, (Map) ZeusTransformUtils.preCheckCast(r0.getTokens(), Map.class, "com.obric.aiagent.plugin")), com.obric.oui.material.c.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L9;
        if (r5 == false) goto L6;
        String r6 = "_light";
    L7:
        r1 = (com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(com.obric.oui.material.o.a(d.h.b.o.a(r4, r6), (Map) ZeusTransformUtils.preCheckCast(r0.getTokens(), Map.class, "com.obric.aiagent.plugin")), com.obric.oui.material.c.class, "com.obric.aiagent.plugin");
        goto L9
    L6:
        r6 = "_dark";
    L9:
        return compatibleConfig(r1);
    }

    public static final com.obric.oui.material.c[] parseSet(String r4, boolean r5) {
        MaterialToken r0 = INSTANCE;
        com.obric.oui.material.c[] r1 = (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(com.obric.oui.material.o.a(r4, (Map) ZeusTransformUtils.preCheckCast(r0.getTokenSets(), Map.class, "com.obric.aiagent.plugin")), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L8;
        if (r5 == false) goto L6;
        String r2 = "_light";
    L7:
        r1 = (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(com.obric.oui.material.o.a(d.h.b.o.a(r4, r2), (Map) ZeusTransformUtils.preCheckCast(r0.getTokenSets(), Map.class, "com.obric.aiagent.plugin")), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin");
        goto L8
    L6:
        r2 = "_dark";
    L8:
        if (r1 != null) goto L13;
        com.obric.oui.material.c r6 = parse(r4, r5);
        if (r6 == null) goto L13;
        r1 = new com.obric.oui.material.c[]{r6};
    L13:
        return compatibleConfigArray(r1);
    }

    public static /* synthetic */ boolean isApiCompatible$default(int r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = 4;
    L6:
        return isApiCompatible(r0);
    }

    public static final boolean isApiCompatible(int r1) {
        if (com.obric.oui.material.l.e() < r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static final com.obric.oui.material.c compatibleConfig(com.obric.oui.material.c r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r1 = com.obric.oui.material.l.e();
        MaterialToken r2 = INSTANCE;
        if (r1 >= 1) goto L9;
        return null;
    L9:
        if (r1 < 4) goto L12;
        return r4.l();
    L12:
        if (r1 < 3) goto L15;
        return r2.toApi3CompatibleConfig(r4);
    L15:
        return r2.toLegacyCompatibleConfig(r4);
    }

    public static final com.obric.oui.material.c[] compatibleConfigArray(com.obric.oui.material.c[] r9) {
        Object[] r0 = null;
        if (r9 != null) goto L5;
        return null;
    L5:
        int r1 = com.obric.oui.material.l.e();
        MaterialToken r2 = INSTANCE;
        if (r1 >= 1) goto L8;
        return null;
    L8:
        d.h.a.b r3 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new r(r2), d.h.a.b.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r5 = r9.length;
        boolean r6 = false;
        int r7 = 0;
    L9:
        if (r7 >= r5) goto L14;
        Object r8 = r3.invoke(r9[r7]);
        if (r8 == null) goto L13;
        r4.add(r8);
    L13:
        r7 = r7 + 1;
        goto L9
    L14:
        Object[] r10 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new com.obric.oui.material.c[0]);
        Objects.requireNonNull(r10, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        if (((com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(r10, com.obric.oui.material.c[].class, "com.obric.aiagent.plugin")).length != 0) goto L18;
        r6 = true;
    L18:
        if ((!r6) == false) goto L21;
        r0 = r10;
    L21:
        return (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.material.c[].class, "com.obric.aiagent.plugin");
    }

    public final com.obric.oui.material.c[] resolveTokenForBuilder$OUI_standardRelease(String r9, boolean r10) {
        com.obric.oui.material.c[] r0 = (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(com.obric.oui.material.n.f35506a.a(r9, (Map) ZeusTransformUtils.preCheckCast(getTokenSets(), Map.class, "com.obric.aiagent.plugin")), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin");
        String r1 = "_light";
        if (r0 != null) goto L10;
        com.obric.oui.material.n r2 = com.obric.oui.material.n.f35506a;
        if (r10 == false) goto L7;
        Object r4 = "_light";
    L8:
        r0 = (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(r2.a(d.h.b.o.a(r9, r4), (Map) ZeusTransformUtils.preCheckCast(getTokenSets(), Map.class, "com.obric.aiagent.plugin")), com.obric.oui.material.c[].class, "com.obric.aiagent.plugin");
        goto L10
    L7:
        r4 = "_dark";
    L10:
        if (r0 == null) goto L16;
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r0.length), Collection.class, "com.obric.aiagent.plugin");
        int r11 = r0.length;
        int r12 = 0;
    L12:
        if (r12 >= r11) goto L14;
        r8.add(r0[r12].l());
        r12 = r12 + 1;
        goto L12
    L14:
        Object[] r13 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new com.obric.oui.material.c[0]);
        Objects.requireNonNull(r13, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(r13, com.obric.oui.material.c[].class, "com.obric.aiagent.plugin");
    L16:
        d.h.a.b r3 = (d.h.a.b) ZeusTransformUtils.preCheckCast(com.obric.oui.material.n.f35506a.a(r9, (Map) ZeusTransformUtils.preCheckCast(getSetProviders(), Map.class, "com.obric.aiagent.plugin")), d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L35;
        com.obric.oui.material.c r5 = (com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(com.obric.oui.material.n.f35506a.a(r9, (Map) ZeusTransformUtils.preCheckCast(getTokens(), Map.class, "com.obric.aiagent.plugin")), com.obric.oui.material.c.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L26;
        com.obric.oui.material.n r6 = com.obric.oui.material.n.f35506a;
        if (r10 == true) goto L24;
        r1 = "_dark";
    L24:
        r5 = (com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(r6.a(d.h.b.o.a(r9, r1), (Map) ZeusTransformUtils.preCheckCast(getTokens(), Map.class, "com.obric.aiagent.plugin")), com.obric.oui.material.c.class, "com.obric.aiagent.plugin");
    L26:
        if (r5 != null) goto L28;
        d.h.a.b r14 = (d.h.a.b) ZeusTransformUtils.preCheckCast(com.obric.oui.material.n.f35506a.a(r9, (Map) ZeusTransformUtils.preCheckCast(getProviders(), Map.class, "com.obric.aiagent.plugin")), d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L34;
        return null;
    L34:
        return new com.obric.oui.material.c[]{((com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(r14.invoke(Boolean.valueOf(r10)), com.obric.oui.material.c.class, "com.obric.aiagent.plugin")).l()};
    L28:
        return new com.obric.oui.material.c[]{r5.l()};
    L35:
        Object[] r15 = (Object[]) ZeusTransformUtils.preCheckCast(r3.invoke(Boolean.valueOf(r10)), Object[].class, "com.obric.aiagent.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r15.length), Collection.class, "com.obric.aiagent.plugin");
        int r17 = r15.length;
        int r7 = 0;
    L36:
        if (r7 >= r17) goto L38;
        r16.add(((com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(r15[r7], com.obric.oui.material.c.class, "com.obric.aiagent.plugin")).l());
        r7 = r7 + 1;
        goto L36
    L38:
        Object[] r18 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new com.obric.oui.material.c[0]);
        Objects.requireNonNull(r18, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (com.obric.oui.material.c[]) ZeusTransformUtils.preCheckCast(r18, com.obric.oui.material.c[].class, "com.obric.aiagent.plugin");
    }

    private final com.obric.oui.material.c toLegacyCompatibleConfig(com.obric.oui.material.c r2) {
        com.obric.oui.material.c r1 = r2.l();
        com.obric.oui.color.a[] r3 = r1.c();
        if (r3 != null) goto L8;
        com.obric.oui.c.a r4 = r1.b();
        if (r4 != null) goto L7;
        r3 = null;
        goto L8
    L7:
        r3 = r4.a();
    L8:
        r1.a(r3);
        r1.a(null);
        com.obric.oui.color.e r5 = r1.e();
        if (r5 != null) goto L14;
        com.obric.oui.c.c r6 = r1.d();
        if (r6 != null) goto L13;
        r5 = null;
        goto L14
    L13:
        r5 = r6.a();
    L14:
        r1.a(r5);
        r1.a(null);
        r1.b(null);
        r1.a(null);
        return r1;
    }

    private final com.obric.oui.material.c toApi3CompatibleConfig(com.obric.oui.material.c r1) {
        return r1.l();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_material_MaterialToken_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
