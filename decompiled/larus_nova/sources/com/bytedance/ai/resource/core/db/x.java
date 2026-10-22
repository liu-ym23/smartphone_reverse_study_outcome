package com.bytedance.ai.resource.core.db;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.model.objects.Widget;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class x extends EntityDeletionOrUpdateAdapter<Widget> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f37456a;

    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "UPDATE OR ABORT `ai_widget_info` SET `widget_id` = ?,`entry` = ?,`input` = ?,`output` = ?,`border` = ?,`box_type` = ?,`title_type` = ?,`name` = ?,`package_name` = ?,`version_code` = ?,`scm_version` = ?,`version_name` = ?,`description` = ?,`icons` = ?,`manifest_version` = ?,`prop` = ?,`recommend` = ?,`keywords` = ?,`app_group` = ?,`id` = ?,`digest` = ?,`render_type` = ?,`size` = ?,`ft` = ?,`it` = ?,`ut` = ?,`update_time` = ?,`create_time` = ?,`status` = ?,`ready_for_deleting` = ?,`runtime_version` = ?,`has_key_store` = ?,`sign_verify_switch` = ?,`app_type` = ?,`source_type` = ? WHERE `id` = ?";
    }

    public x(j r100, AIPackageDatabase r101) {
        this.f37456a = r100;
        super(r101);
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final void bind(SupportSQLiteStatement r100, Widget r101) {
        Widget r102 = r101;
        String r103 = r102.K;
        if (r103 != null) goto L5;
        r100.bindNull(1);
    L6:
        String r104 = r102.L;
        if (r104 != null) goto L9;
        r100.bindNull(2);
    L10:
        String r105 = r102.M;
        if (r105 != null) goto L13;
        r100.bindNull(3);
    L14:
        String r106 = r102.N;
        if (r106 != null) goto L17;
        r100.bindNull(4);
    L18:
        r100.bindLong(5, r102.O ? 1 : 0);
        r100.bindLong(6, r102.P);
        Integer r107 = r102.Q;
        if (r107 != null) goto L21;
        r100.bindNull(7);
    L22:
        String r108 = r102.f36894a;
        if (r108 != null) goto L25;
        r100.bindNull(8);
    L26:
        String r109 = r102.f36895b;
        if (r109 != null) goto L29;
        r100.bindNull(9);
    L30:
        r100.bindLong(10, r102.f36896c);
        String r110 = r102.f36897d;
        if (r110 != null) goto L33;
        r100.bindNull(11);
    L34:
        String r111 = r102.f36898e;
        if (r111 != null) goto L37;
        r100.bindNull(12);
    L38:
        String r112 = r102.f36899f;
        if (r112 != null) goto L41;
        r100.bindNull(13);
    L42:
        Icons r113 = r102.f36900g;
        String r114 = null;
        if (r113 != null) goto L45;
        String r115 = null;
    L47:
        if (r115 != null) goto L49;
        r100.bindNull(14);
    L50:
        String r116 = r102.f36901h;
        if (r116 != null) goto L53;
        r100.bindNull(15);
    L54:
        String r117 = r102.f36902i;
        if (r117 != null) goto L57;
        r100.bindNull(16);
    L58:
        String r118 = r102.f36903j;
        if (r118 != null) goto L61;
        r100.bindNull(17);
    L62:
        List<String> r119 = r102.f36904k;
        if (r119 == null) goto L67;
        this.f37456a.f37378d.getClass();
        Intrinsics.checkNotNullParameter(r119, "list");
        r114 = com.bytedance.ai.applet.base.gson.e.c(r119);
    L67:
        if (r114 != null) goto L69;
        r100.bindNull(18);
    L70:
        String r120 = r102.f36905l;
        if (r120 != null) goto L73;
        r100.bindNull(19);
    L74:
        r100.bindLong(20, r102.f36906m);
        String r121 = r102.f36907n;
        if (r121 != null) goto L77;
        r100.bindNull(21);
    L78:
        String r122 = r102.f36908o;
        if (r122 != null) goto L81;
        r100.bindNull(22);
    L82:
        r100.bindLong(23, r102.f36909p);
        r100.bindLong(24, r102.f36910q);
        r100.bindLong(25, r102.f36911r);
        r100.bindLong(26, r102.f36912s);
        r100.bindLong(27, r102.f36913t);
        r100.bindLong(28, r102.f36914u);
        String r123 = r102.f36915v;
        if (r123 != null) goto L85;
        r100.bindNull(29);
    L86:
        Integer r124 = r102.f36916w;
        if (r124 != null) goto L89;
        r100.bindNull(30);
    L90:
        String r125 = r102.C;
        if (r125 != null) goto L93;
        r100.bindNull(31);
    L94:
        r100.bindLong(32, r102.D);
        r100.bindLong(33, r102.E);
        r100.bindLong(34, r102.F);
        r100.bindLong(35, r102.G);
        r100.bindLong(36, r102.f36906m);
        return;
    L93:
        r100.bindString(31, r125);
        goto L94
    L89:
        r100.bindLong(30, r124.intValue());
        goto L90
    L85:
        r100.bindString(29, r123);
        goto L86
    L81:
        r100.bindString(22, r122);
        goto L82
    L77:
        r100.bindString(21, r121);
        goto L78
    L73:
        r100.bindString(19, r120);
        goto L74
    L69:
        r100.bindString(18, r114);
        goto L70
    L61:
        r100.bindString(17, r118);
        goto L62
    L57:
        r100.bindString(16, r117);
        goto L58
    L53:
        r100.bindString(15, r116);
        goto L54
    L49:
        r100.bindString(14, r115);
        goto L50
    L45:
        this.f37456a.f37378d.getClass();
        Intrinsics.checkNotNullParameter(r113, "icons");
        r115 = com.bytedance.ai.applet.base.gson.e.c(r113);
        goto L47
    L41:
        r100.bindString(13, r112);
        goto L42
    L37:
        r100.bindString(12, r111);
        goto L38
    L33:
        r100.bindString(11, r110);
        goto L34
    L29:
        r100.bindString(9, r109);
        goto L30
    L25:
        r100.bindString(8, r108);
        goto L26
    L21:
        r100.bindLong(7, r107.intValue());
        goto L22
    L17:
        r100.bindString(4, r106);
        goto L18
    L13:
        r100.bindString(3, r105);
        goto L14
    L9:
        r100.bindString(2, r104);
        goto L10
    L5:
        r100.bindString(1, r103);
        goto L6
    }
}
