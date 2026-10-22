package com.bytedanceos.common.utils;

import android.R;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.UserHandle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import java.lang.reflect.InvocationTargetException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class CompatAppSecurityPermisions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutInflater f10146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PackageManager f10147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f10148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f10149e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f10150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f10151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f10152h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CharSequence f10153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f10154j;

    public static class MyPermissionGroupInfo extends PermissionGroupInfo {
        final ArrayList<MyPermissionInfo> mAllPermissions;
        CharSequence mLabel;
        final ArrayList<MyPermissionInfo> mNewPermissions;

        public MyPermissionGroupInfo(PermissionInfo r10) {
            this.mNewPermissions = new ArrayList();
            this.mAllPermissions = new ArrayList();
            String r11 = r10.packageName;
            ((PermissionGroupInfo) this).name = r11;
            ((PermissionGroupInfo) this).packageName = r11;
        }

        @SuppressLint({"NewApi"})
        public Drawable loadGroupIcon(Context r10, PackageManager r11) {
            if (((PermissionGroupInfo) this).icon == 0) goto L7;
            return loadUnbadgedIcon(r11);
        L7:
            return r10.getDrawable(R.drawable.pointer_vertical_text_icon);
        }

        public MyPermissionGroupInfo(PermissionGroupInfo r10) {
            super(r10);
            this.mNewPermissions = new ArrayList();
            this.mAllPermissions = new ArrayList();
        }
    }

    public static class MyPermissionInfo extends PermissionInfo {
        int mExistingReqFlags;
        CharSequence mLabel;
        boolean mNew;
        int mNewReqFlags;

        public MyPermissionInfo(PermissionInfo r10) {
            super(r10);
        }

        public CharSequence getLabel() {
            return this.mLabel;
        }
    }

    public static class PermissionItemView extends LinearLayout implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MyPermissionGroupInfo f10155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MyPermissionInfo f10156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AlertDialog f10157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f10158d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f10159e;

        public class a implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PermissionItemView f10160a;

            public a(PermissionItemView r10) {
                this.f10160a = r10;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface r10, int r11) {
                PackageManager r12 = this.f10160a.getContext().getPackageManager();
                if (r12 != null) goto L5;
                com.bytedanceos.common.toolbox.i.b("AppSecurityPermissions", "PackageManager is null!");
            L5:
                r12.revokeRuntimePermission(PermissionItemView.a(this.f10160a), ((PermissionInfo) this.f10160a.f10156b).name, new UserHandle(PermissionItemView.b(this.f10160a).getUserId()));
                this.f10160a.setVisibility(8);
            }
        }

        public PermissionItemView(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.f10158d = false;
            setClickable(true);
        }

        public static /* synthetic */ String a(PermissionItemView r10) {
            return r10.f10159e;
        }

        public static /* synthetic */ Context b(PermissionItemView r10) {
            return ((LinearLayout) r10).mContext;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private String getPermissionDesc() {
            if (this.f10155a != null) goto L5;
        L23:
            return null;
        L5:
            if (this.f10156b == null) goto L23;
            PackageManager r10 = getContext().getPackageManager();
            if (r10 != null) goto L9;
            com.bytedanceos.common.toolbox.i.b("AppSecurityPermissions", "PackageManager is null!");
        L9:
            MyPermissionInfo r11 = this.f10156b;
            if (((PermissionInfo) r11).descriptionRes == 0) goto L15;
            CharSequence r12 = r11.loadDescription(r10);
            if (r12 != null) goto L14;
            return null;
        L14:
            return r12.toString();
        L15:
            String r13 = ((PermissionInfo) r11).packageName;
            ApplicationInfo r14 = r10.getApplicationInfo(r13, 0);     // Catch: PackageManager.NameNotFoundException -> L20
            String r15 = r13;
            if (r14 == null) goto L21;
            r15 = r14.loadLabel(r10);     // Catch: PackageManager.NameNotFoundException -> L20
        L21:
            StringBuilder r16 = new StringBuilder(128);
            r16.append(getContext().getString(R.string.roamingText0, new Object[]{r15}));
            r16.append("\n\n");
            r16.append(((PermissionInfo) this.f10156b).name);
            return r16.toString();
        L20:
            r15 = ((PermissionInfo) this.f10156b).packageName;
            goto L21
        }

        public final void c(AlertDialog.Builder r10) {
            if (this.f10158d == true) goto L6;
            return;
        L6:
            if ((this.f10156b.mExistingReqFlags & 1) == 0) goto L8;
            return;
        L8:
            r10.setNegativeButton(R.string.status_bar_data_connection, new a(this));
            r10.setPositiveButton(R.string.ok, null);
        }

        public void d(MyPermissionGroupInfo r10, MyPermissionInfo r11, boolean r12, CharSequence r13, String r14, boolean r15) {
            this.f10155a = r10;
            this.f10156b = r11;
            this.f10158d = r15;
            this.f10159e = r14;
            TextView r16 = (TextView) findViewById(R$id.perm_name);
            TextView r17 = (TextView) findViewById(R$id.perm_desc);
            CharSequence r18 = r11.mLabel;
            CharSequence r19 = r18;
            r19 = r18;
            if (r11.mNew == false) goto L6;
            if (r13 == null) goto L6;
            SpannableStringBuilder r20 = new SpannableStringBuilder();
            Parcel r21 = Parcel.obtain();
            TextUtils.writeToParcel(r13, r21, 0);
            r21.setDataPosition(0);
            CharSequence r22 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r21);
            r21.recycle();
            r20.append(r22);
            r20.append(r18);
            r19 = r20;
        L6:
            if (r16 == null) goto L8;
            r16.setText(r19);
        L8:
            String r23 = getPermissionDesc();
            com.bytedanceos.common.toolbox.i.b("permDesc", "permDesc" + r23);
            if (r23 == null) goto L13;
            if (r17 == null) goto L14;
            r17.setText(r23);
            return;
        L14:
            return;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            if (this.f10155a != null) goto L5;
            return;
        L5:
            if (this.f10156b == null) goto L27;
            AlertDialog r11 = this.f10157c;
            if (r11 == null) goto L9;
            r11.dismiss();
        L9:
            PackageManager r12 = getContext().getPackageManager();
            if (r12 != null) goto L12;
            com.bytedanceos.common.toolbox.i.b("AppSecurityPermissions", "PackageManager is null!");
        L12:
            AlertDialog.Builder r13 = new AlertDialog.Builder(getContext());
            r13.setTitle(this.f10155a.mLabel);
            MyPermissionInfo r14 = this.f10156b;
            if (((PermissionInfo) r14).descriptionRes == 0) goto L15;
            r13.setMessage(r14.loadDescription(r12));
        L22:
            r13.setCancelable(true);
            r13.setIcon(this.f10155a.loadGroupIcon(getContext(), r12));
            c(r13);
            AlertDialog r15 = r13.show();
            this.f10157c = r15;
            r15.setCanceledOnTouchOutside(true);
            return;
        L15:
            String r16 = ((PermissionInfo) r14).packageName;
            ApplicationInfo r17 = r12.getApplicationInfo(r16, 0);     // Catch: PackageManager.NameNotFoundException -> L20
            String r18 = r16;
            if (r17 == null) goto L21;
            r18 = r17.loadLabel(r12);     // Catch: PackageManager.NameNotFoundException -> L20
        L21:
            StringBuilder r19 = new StringBuilder(128);
            r19.append(getContext().getString(R.string.roamingText0, new Object[]{r18}));
            r19.append("\n\n");
            r19.append(((PermissionInfo) this.f10156b).name);
            r13.setMessage(r19.toString());
        L20:
            r18 = ((PermissionInfo) this.f10156b).packageName;
            goto L21
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            AlertDialog r10 = this.f10157c;
            if (r10 == null) goto L6;
            r10.dismiss();
            return;
        }
    }

    public static /* synthetic */ class a {
    }

    public static class b implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collator f10161a;

        public b() {
            this.f10161a = Collator.getInstance();
        }

        public final int a(MyPermissionGroupInfo r10, MyPermissionGroupInfo r11) {
            return this.f10161a.compare(r10.mLabel, r11.mLabel);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((MyPermissionGroupInfo) r10, (MyPermissionGroupInfo) r11);
        }

        public /* synthetic */ b(a r10) {
            this();
        }
    }

    public static class c implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collator f10162a;

        public c() {
            this.f10162a = Collator.getInstance();
        }

        public final int a(MyPermissionInfo r10, MyPermissionInfo r11) {
            return this.f10162a.compare(r10.mLabel, r11.mLabel);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((MyPermissionInfo) r10, (MyPermissionInfo) r11);
        }
    }

    public CompatAppSecurityPermisions(Context r10) {
        this.f10148d = new HashMap();
        this.f10149e = new ArrayList();
        this.f10150f = new b(null);
        this.f10151g = new c();
        this.f10152h = new ArrayList();
        this.f10145a = r10;
        this.f10146b = (LayoutInflater) r10.getSystemService("layout_inflater");
        this.f10147c = r10.getPackageManager();
        this.f10153i = r10.getText(R.string.roamingText1);
    }

    public static PermissionItemView f(Context r10, LayoutInflater r11, MyPermissionGroupInfo r12, MyPermissionInfo r13, boolean r14, CharSequence r15, String r16, boolean r17) {
        PermissionItemView r18 = (PermissionItemView) r11.inflate(R$layout.app_permission_item, null);
        r18.d(r12, r13, r14, r15, r16, r17);
        return r18;
    }

    public final void a(List r10, MyPermissionInfo r11) {
        if (r11.mLabel != null) goto L5;
        o(r11);
    L5:
        int r12 = Collections.binarySearch(r10, r11, this.f10151g);
        if (r12 >= 0) goto L9;
        r10.add((-r12) - 1, r11);
        return;
    }

    public final void b(List r12, LinearLayout r13, int r14, boolean r15) {
        r13.removeAllViews();
        int r10 = 0;
    L4:
        if (r10 >= r12.size()) goto L19;
        MyPermissionGroupInfo r11 = (MyPermissionGroupInfo) r12.get(r10);
        List r16 = h(r11, r14);
        int r17 = 0;
    L7:
        if (r17 >= r16.size()) goto L18;
        MyPermissionInfo r18 = (MyPermissionInfo) r16.get(r17);
        if (r17 != 0) goto L11;
        boolean r19 = true;
    L13:
        if (r14 == 4) goto L16;
        CharSequence r20 = this.f10153i;
    L17:
        r13.addView(g(r11, r18, r19, r20, r15), new LinearLayout.LayoutParams(-1, -2));
        r17 = r17 + 1;
        goto L7
    L16:
        r20 = null;
        goto L17
    L11:
        r19 = false;
        goto L13
    L18:
        r10 = r10 + 1;
        goto L4
    }

    public final void c(PackageInfo r10, Set r11, PackageInfo r12) {
        String[] r13 = r10.requestedPermissions;
        int[] r14 = r10.requestedPermissionsFlags;
        if (r13 != null) goto L5;
        return;
    L5:
        if (r13.length == 0) goto L66;
        int r15 = 0;
    L9:
        if (r15 >= r13.length) goto L67;
        String r16 = r13[r15];
        PermissionInfo r17 = this.f10147c.getPermissionInfo(r16, 0);     // Catch: PackageManager.NameNotFoundException -> L54
        if (r17 == null) goto L55;
        if (r12 != null) goto L16;
    L24:
        int r18 = -1;
    L25:
        if (r18 < 0) goto L27;
        int r19 = r12.requestedPermissionsFlags[r18];     // Catch: PackageManager.NameNotFoundException -> L54
    L29:
        if (p(r17, r14[r15], r19) == false) goto L55;
        String r20 = r17.group;     // Catch: PackageManager.NameNotFoundException -> L54
        if (r20 != null) goto L34;
        String r21 = r17.packageName;     // Catch: PackageManager.NameNotFoundException -> L54
        r17.group = r21;     // Catch: PackageManager.NameNotFoundException -> L54
    L36:
        if (((MyPermissionGroupInfo) this.f10148d.get(r21)) != null) goto L47;
        if (r20 == null) goto L39;
        PermissionGroupInfo r22 = this.f10147c.getPermissionGroupInfo(r20, 0);     // Catch: PackageManager.NameNotFoundException -> L54
    L40:
        if (r22 == null) goto L42;
        MyPermissionGroupInfo r23 = new MyPermissionGroupInfo(r22);     // Catch: PackageManager.NameNotFoundException -> L54
    L46:
        this.f10148d.put(r17.group, r23);     // Catch: PackageManager.NameNotFoundException -> L54
        goto L47
    L42:
        String r24 = r17.packageName;     // Catch: PackageManager.NameNotFoundException -> L54
        r17.group = r24;     // Catch: PackageManager.NameNotFoundException -> L54
        if (((MyPermissionGroupInfo) this.f10148d.get(r24)) != null) goto L45;
        new MyPermissionGroupInfo(r17);     // Catch: PackageManager.NameNotFoundException -> L54
    L45:
        r23 = new MyPermissionGroupInfo(r17);     // Catch: PackageManager.NameNotFoundException -> L54
        goto L46
    L39:
        r22 = null;
    L47:
        if (r12 != null) goto L49;
    L51:
        boolean r25 = false;
    L52:
        MyPermissionInfo r26 = new MyPermissionInfo(r17);     // Catch: PackageManager.NameNotFoundException -> L54
        r26.mNewReqFlags = r14[r15];     // Catch: PackageManager.NameNotFoundException -> L54
        r26.mExistingReqFlags = r19;     // Catch: PackageManager.NameNotFoundException -> L54
        r26.mNew = r25;     // Catch: PackageManager.NameNotFoundException -> L54
        r11.add(r26);     // Catch: PackageManager.NameNotFoundException -> L54
        goto L55
    L49:
        if ((r19 & 2) != 0) goto L51;
        r25 = true;
        goto L52
    L34:
        r21 = r20;
        goto L36
    L27:
        r19 = 0;
        goto L29
    L16:
        if (r12.requestedPermissions == null) goto L24;
        r18 = 0;
    L18:
        String[] r27 = r12.requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L54
        if (r18 >= r27.length) goto L24;
        if (r16.equals(r27[r18]) == true) goto L25;
        r18 = r18 + 1;     // Catch: PackageManager.NameNotFoundException -> L54
    L55:
        r15 = r15 + 1;
    L54:
        com.bytedanceos.common.toolbox.i.e("AppSecurityPermissions", "Ignoring unknown permission:" + r16);
        goto L55
    L67:
        return;
    }

    public final void d(int r10, Set r11) {
        String[] r12 = this.f10147c.getPackagesForUid(r10);
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.length == 0) goto L12;
        int r13 = r12.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L13;
        j(r12[r14], r11);
        r14 = r14 + 1;
        goto L8
    L13:
        return;
    }

    public final CharSequence e(Object r10) {
        Class<?> r11 = Class.forName("android.content.pm.PackageItemInfo");     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
        Object r12 = ReflectTool.getFiledNameFromClass("android.content.pm.PackageItemInfo", "SAFE_LABEL_FLAG_TRIM");     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
        Object r13 = ReflectTool.getFiledNameFromClass("android.content.pm.PackageItemInfo", "SAFE_LABEL_FLAG_FIRST_LINE");     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
        int r14 = ((Integer) r12).intValue();     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
        int r15 = ((Integer) r13).intValue() | r14;     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
        return (CharSequence) r11.getMethod("loadSafeLabel", new Class[]{PackageManager.class, Float.TYPE, Integer.TYPE}).invoke(r10, new Object[]{this.f10147c, 20000, Integer.valueOf(r15)});
    L11:
        e = move-exception;
        e.printStackTrace();
        return "";
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    L9:
        e = move-exception;
        e.printStackTrace();
        return "";
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public final PermissionItemView g(MyPermissionGroupInfo r10, MyPermissionInfo r11, boolean r12, CharSequence r13, boolean r14) {
        return f(this.f10145a, this.f10146b, r10, r11, r12, r13, this.f10154j, r14);
    }

    public final List h(MyPermissionGroupInfo r10, int r11) {
        if (r11 != 4) goto L7;
        return r10.mNewPermissions;
    L7:
        return r10.mAllPermissions;
    }

    public List i() {
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L4:
        if (r11 >= this.f10149e.size()) goto L6;
        r10.addAll(h((MyPermissionGroupInfo) this.f10149e.get(r11), SupportMenu.USER_MASK));
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    public final void j(String r10, Set r11) {
        PackageInfo r12 = this.f10147c.getPackageInfo(r10, 4096);     // Catch: PackageManager.NameNotFoundException -> L6
        if (r12 == null) goto L10;
        c(r12, r11, r12);     // Catch: PackageManager.NameNotFoundException -> L6
        return;
    L10:
        return;
    L6:
        com.bytedanceos.common.toolbox.i.k("AppSecurityPermissions", "Couldn't retrieve permissions for package: " + r10);
    }

    public View k() {
        return l(SupportMenu.USER_MASK, false);
    }

    public final View l(int r10, boolean r11) {
        LinearLayout r12 = (LinearLayout) this.f10146b.inflate(R$layout.app_perms_summary, null);
        LinearLayout r13 = (LinearLayout) r12.findViewById(R$id.perms_list);
        View r14 = r12.findViewById(R$id.no_permissions);
        b(this.f10149e, r13, r10, r11);
        if (r13.getChildCount() > 0) goto L5;
        r14.setVisibility(0);
    L5:
        return r12;
    }

    public final void m(MyPermissionGroupInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.mLabel = e(r10);
    }

    public final void n(MyPermissionGroupInfo r10, ApplicationInfo r11) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L8;
        r10.mLabel = e(r11);
        return;
    L8:
        return;
    }

    public final void o(MyPermissionInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.mLabel = e(r10);
    }

    public final boolean p(PermissionInfo r10, int r11, int r12) {
        int r13 = r10.protectionLevel;
        int r14 = r13 & 15;
        if (r14 != 0) goto L6;
        return false;
    L6:
        if (r14 != 1) goto L8;
    L11:
        boolean r15 = true;
    L13:
        if ((r11 & 1) == 0) goto L15;
        boolean r16 = true;
    L17:
        if ((r13 & 32) == 0) goto L19;
        boolean r17 = true;
    L21:
        if ((r12 & 2) == 0) goto L23;
        boolean r18 = true;
    L25:
        if ((r11 & 2) == 0) goto L27;
        boolean r19 = true;
    L28:
        if (r15 == false) goto L33;
        if (r16 == true) goto L32;
        if (r18 == true) goto L32;
        if (r19 == false) goto L33;
    L32:
        return true;
    L33:
        if (r17 == false) goto L36;
        if (r18 == false) goto L36;
        return true;
    L36:
        return false;
    L27:
        r19 = false;
        goto L28
    L23:
        r18 = false;
        goto L25
    L19:
        r17 = false;
        goto L21
    L15:
        r16 = false;
        goto L17
    L8:
        if ((r13 & 128) != 0) goto L11;
        r15 = false;
        goto L13
    }

    public final void q(List r10) {
        if (r10 == null) goto L14;
        Iterator r11 = r10.iterator();
    L5:
        if (r11.hasNext() == false) goto L14;
        MyPermissionInfo r12 = (MyPermissionInfo) r11.next();
        if (p(r12, r12.mNewReqFlags, r12.mExistingReqFlags) == false) goto L5;
        MyPermissionGroupInfo r13 = (MyPermissionGroupInfo) this.f10148d.get(((PermissionInfo) r12).group);
        if (r13 == null) goto L5;
        o(r12);
        a(r13.mAllPermissions, r12);
        if (r12.mNew == false) goto L5;
        a(r13.mNewPermissions, r12);
    L14:
        Iterator r14 = this.f10148d.values().iterator();
    L16:
        if (r14.hasNext() == false) goto L27;
        MyPermissionGroupInfo r15 = (MyPermissionGroupInfo) r14.next();
        if (((PermissionGroupInfo) r15).labelRes == 0) goto L20;
    L25:
        m(r15);
    L26:
        this.f10149e.add(r15);
        goto L16
    L20:
        if (((PermissionGroupInfo) r15).nonLocalizedLabel != null) goto L25;
        n(r15, this.f10147c.getApplicationInfo(((PermissionGroupInfo) r15).packageName, 0));     // Catch: PackageManager.NameNotFoundException -> L24
    L24:
        m(r15);
        goto L26
    L27:
        Collections.sort(this.f10149e, this.f10150f);
    }

    public CompatAppSecurityPermisions(Context r10, PackageInfo r11) {
        this(r10);
        HashSet r12 = new HashSet();
        if (r11 != null) goto L5;
        return;
    L5:
        String r13 = r11.packageName;
        this.f10154j = r13;
        if (r11.requestedPermissions != null) goto L21;
    L12:
        String r14 = r11.sharedUserId;
        if (r14 != null) goto L19;
    L17:
        this.f10152h.addAll(r12);
        q(this.f10152h);
        return;
    L19:
        d(this.f10147c.getUidForSharedUser(r14), r12);     // Catch: PackageManager.NameNotFoundException -> L16
    L16:
        com.bytedanceos.common.toolbox.i.k("AppSecurityPermissions", "Couldn't retrieve shared user id for: " + r11.packageName);
        goto L17
    L21:
        PackageInfo r15 = this.f10147c.getPackageInfo(r13, 4096);     // Catch: PackageManager.NameNotFoundException -> L9
    L11:
        c(r11, r12, r15);
    L9:
        e = move-exception;
        e.printStackTrace();
        r15 = null;
        goto L11
    }
}
