package com.obric.aiagent.skill.manager.impl.ui;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillFormFileState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class au {

    /* JADX INFO: compiled from: SkillFormFileState.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20573a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f20574b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f20575c = null;

        static {
            int[] r0 = new int[bf.values().length];
            r0[bf.f20636a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L35:
            r0[bf.f20637b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L47:
            r0[bf.f20638c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L37:
            r0[bf.f20639d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L39:
            r0[bf.f20640e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L10:
            f20573a = r0;
            int[] r1 = new int[av.values().length];
            r1[av.f20576a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L29:
            r1[av.f20577b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L13:
            f20574b = r1;
            int[] r2 = new int[com.obric.aiagent.skill.manager.impl.cc.values().length];
            r2[com.obric.aiagent.skill.manager.impl.cc.f19640a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L43:
            r2[com.obric.aiagent.skill.manager.impl.cc.f19641b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L31:
            r2[com.obric.aiagent.skill.manager.impl.cc.f19642c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L17:
            f20575c = r2;
        }
    }

    public static final /* synthetic */ com.obric.aiagent.skill.manager.impl.bt a(bf r0, ao r1) {
        return b(r0, r1);
    }

    private static final com.obric.aiagent.skill.manager.impl.bt b(bf r2, ao r3) {
        int r4 = a.f20573a[r2.ordinal()];
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L23;
        if (r4 == 3) goto L22;
        if (r4 == 4) goto L21;
        if (r4 != 5) goto L14;
        return (com.obric.aiagent.skill.manager.impl.bt) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.bt.b.f19594a, com.obric.aiagent.skill.manager.impl.bt.class, "com.obric.aiagent.plugin");
    L14:
        throw new d.k();
    L21:
        return (com.obric.aiagent.skill.manager.impl.bt) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.impl.bt.d(r3.b()), com.obric.aiagent.skill.manager.impl.bt.class, "com.obric.aiagent.plugin");
    L22:
        return (com.obric.aiagent.skill.manager.impl.bt) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.bt.c.f19595a, com.obric.aiagent.skill.manager.impl.bt.class, "com.obric.aiagent.plugin");
    L23:
        return (com.obric.aiagent.skill.manager.impl.bt) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.manager.impl.bt.r(r3.a()), com.obric.aiagent.skill.manager.impl.bt.class, "com.obric.aiagent.plugin");
    L19:
        return (com.obric.aiagent.skill.manager.impl.bt) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.bt.q.f19609a, com.obric.aiagent.skill.manager.impl.bt.class, "com.obric.aiagent.plugin");
    }

    public static final an a(String r5, boolean r6) {
        d.h.b.o.e(r5, "coverUrl");
        boolean r0 = true;
        boolean r7 = !d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"));
        boolean r2 = !r7;
        if (r6 == false) goto L6;
        if (r7 == true) goto L6;
        boolean r4 = true;
    L7:
        if (r6 == false) goto L10;
        if (r7 == false) goto L10;
    L12:
        return new an(r2, r4, r0, r6);
    L10:
        r0 = false;
    L6:
        r4 = false;
        goto L7
    }

    public static final ar a(as.b r2) {
        d.h.b.o.e(r2, "<this>");
        av r0 = r2.b();
        int r1 = a.f20574b[r0.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L8;
        return c(r2);
    L8:
        throw new d.k();
    L10:
        return b(r2);
    }

    private static final ar b(as.b r22) {
        at r0 = r22.c();
        if (d.h.b.o.a(r0, at.b.f20570a) == false) goto L6;
        return new ar("Skill.md", null, "", false, null, Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_skill_file_modify_action, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_modify_action")), true, true, true, true, false, null, null, 6162, null);
    L6:
        if (ZeusTransformUtils.instanceOf(r0, at.c.class) == false) goto L9;
        return new ar(((at.c) ZeusTransformUtils.preCheckCast(r0, at.c.class, "com.obric.aiagent.plugin")).a(), null, "", false, "", null, false, false, false, false, false, null, null, 6178, null);
    L9:
        if (ZeusTransformUtils.instanceOf(r0, at.d.class) == false) goto L12;
        return new ar("Skill.md", null, "", false, null, Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_skill_file_modify_action, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_modify_action")), true, true, true, true, false, null, null, 6162, null);
    L12:
        if (ZeusTransformUtils.instanceOf(r0, at.a.class) == false) goto L16;
        ah r1 = a((at.a) ZeusTransformUtils.preCheckCast(r0, at.a.class, "com.obric.aiagent.plugin"));
        return new ar(((at.a) ZeusTransformUtils.preCheckCast(r0, at.a.class, "com.obric.aiagent.plugin")).a(), null, "", true, null, Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_skill_file_modify_action, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_modify_action")), true, true, true, true, false, Integer.valueOf(r1.a()), r1.b(), 18, null);
    L16:
        throw new d.k();
    }

    private static final ar c(as.b r22) {
        at r0 = r22.c();
        if (d.h.b.o.a(r0, at.b.f20570a) == false) goto L6;
        return new ar(null, Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_skill_file_upload_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_upload_title")), "", false, null, Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_skill_file_select_action, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_select_action")), true, true, true, true, false, null, null, 6161, null);
    L6:
        if (ZeusTransformUtils.instanceOf(r0, at.c.class) == false) goto L9;
        return new ar(((at.c) ZeusTransformUtils.preCheckCast(r0, at.c.class, "com.obric.aiagent.plugin")).a(), null, "", false, null, Integer.valueOf(ZeusTransformUtils.mapRes(R.string.obric_skill_file_parsing_action, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_parsing_action")), false, false, true, true, false, null, null, 6162, null);
    L9:
        if (ZeusTransformUtils.instanceOf(r0, at.d.class) == false) goto L16;
        if (r22.e() == null) goto L13;
        boolean r16 = true;
    L27:
        return new ar("Skill.md", null, "", false, "", null, true, false, false, false, r16, null, null, 6178, null);
    L13:
        r16 = false;
        goto L27
    L16:
        if (ZeusTransformUtils.instanceOf(r0, at.a.class) == false) goto L24;
        ah r1 = a((at.a) ZeusTransformUtils.preCheckCast(r0, at.a.class, "com.obric.aiagent.plugin"));
        String r6 = ((at.a) ZeusTransformUtils.preCheckCast(r0, at.a.class, "com.obric.aiagent.plugin")).a();
        if (r22.e() == null) goto L20;
        boolean r17 = true;
    L22:
        return new ar(r6, null, "", true, "", null, true, true, false, false, r17, Integer.valueOf(r1.a()), r1.b(), 34, null);
    L20:
        r17 = false;
        goto L22
    L24:
        throw new d.k();
    }

    private static final ah a(at.a r7) {
        com.obric.aiagent.skill.manager.impl.bt r0 = r7.b();
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.s.f19611a) == false) goto L6;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_picker_unavailable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_picker_unavailable"));
    L6:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.g.f19599a) == false) goto L9;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_file_unavailable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_file_unavailable"));
    L9:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.impl.bt.z.class) == false) goto L16;
        if (((com.obric.aiagent.skill.manager.impl.bt.z) ZeusTransformUtils.preCheckCast(r7.b(), com.obric.aiagent.skill.manager.impl.bt.z.class, "com.obric.aiagent.plugin")).b() != com.obric.aiagent.skill.manager.impl.bw.f19620a) goto L13;
        int r8 = ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_unsupported_import_type, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_unsupported_import_type");
    L108:
        return a(r8);
    L13:
        r8 = ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_unsupported_markdown_type, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_unsupported_markdown_type");
        goto L108
    L16:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.m.f19605a) == false) goto L19;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_markdown_content_mismatch, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_markdown_content_mismatch"));
    L19:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.impl.bt.w.class) == false) goto L22;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_source_too_large, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_source_too_large"), new Object[]{a(((com.obric.aiagent.skill.manager.impl.bt.w) ZeusTransformUtils.preCheckCast(r7.b(), com.obric.aiagent.skill.manager.impl.bt.w.class, "com.obric.aiagent.plugin")).b())});
    L22:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.impl.bt.v.class) == false) goto L25;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_skill_markdown_too_large, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_skill_markdown_too_large"), new Object[]{a(((com.obric.aiagent.skill.manager.impl.bt.v) ZeusTransformUtils.preCheckCast(r7.b(), com.obric.aiagent.skill.manager.impl.bt.v.class, "com.obric.aiagent.plugin")).b())});
    L25:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.impl.bt.aa.class) == false) goto L28;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_zip_entry_too_large, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_zip_entry_too_large"), new Object[]{a(((com.obric.aiagent.skill.manager.impl.bt.aa) ZeusTransformUtils.preCheckCast(r7.b(), com.obric.aiagent.skill.manager.impl.bt.aa.class, "com.obric.aiagent.plugin")).b())});
    L28:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.impl.bt.ab.class) == false) goto L31;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_zip_package_too_large, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_zip_package_too_large"), new Object[]{a(((com.obric.aiagent.skill.manager.impl.bt.ab) ZeusTransformUtils.preCheckCast(r7.b(), com.obric.aiagent.skill.manager.impl.bt.ab.class, "com.obric.aiagent.plugin")).b())});
    L31:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.impl.bt.ac.class) == false) goto L34;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_zip_too_many_entries, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_zip_too_many_entries"), new Object[]{Integer.valueOf(((com.obric.aiagent.skill.manager.impl.bt.ac) ZeusTransformUtils.preCheckCast(r7.b(), com.obric.aiagent.skill.manager.impl.bt.ac.class, "com.obric.aiagent.plugin")).b())});
    L34:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.l.f19604a) == false) goto L37;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_invalid_zip, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_invalid_zip"));
    L37:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.y.f19617a) == false) goto L40;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_unsafe_zip_path, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_unsafe_zip_path"));
    L40:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.f.f19598a) == false) goto L43;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_duplicate_zip_entry, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_duplicate_zip_entry"));
    L43:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.x.f19616a) == false) goto L46;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_store_only_package, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_store_only_package"));
    L46:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.n.f19606a) == false) goto L49;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_missing_skill_markdown, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_missing_skill_markdown"));
    L49:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.o.f19607a) == false) goto L52;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_multiple_skill_markdown, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_multiple_skill_markdown"));
    L52:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.k.f19603a) == false) goto L55;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_invalid_skill_markdown_location, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_invalid_skill_markdown_location"));
    L55:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.impl.bt.u.class) == false) goto L58;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_skill_markdown_content_too_long, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_skill_markdown_content_too_long"), new Object[]{Integer.valueOf(((com.obric.aiagent.skill.manager.impl.bt.u) ZeusTransformUtils.preCheckCast(r7.b(), com.obric.aiagent.skill.manager.impl.bt.u.class, "com.obric.aiagent.plugin")).b())});
    L58:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.impl.bt.a.class) == false) goto L61;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_assisted_markdown_content_too_long, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_assisted_markdown_content_too_long"), new Object[]{Integer.valueOf(((com.obric.aiagent.skill.manager.impl.bt.a) ZeusTransformUtils.preCheckCast(r7.b(), com.obric.aiagent.skill.manager.impl.bt.a.class, "com.obric.aiagent.plugin")).b())});
    L61:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.h.f19600a) == false) goto L64;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_frontmatter_missing, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_frontmatter_missing"));
    L64:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.i.f19601a) == false) goto L67;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_frontmatter_unclosed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_frontmatter_unclosed"));
    L67:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.impl.bt.e.class) == false) goto L80;
        int r9 = a.f20575c[((com.obric.aiagent.skill.manager.impl.bt.e) ZeusTransformUtils.preCheckCast(r7.b(), com.obric.aiagent.skill.manager.impl.bt.e.class, "com.obric.aiagent.plugin")).b().ordinal()];
        if (r9 != 1) goto L71;
    L77:
        int r10 = ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_duplicate_name, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_duplicate_name");
    L126:
        return a(r10);
    L71:
        if (r9 == 2) goto L77;
        if (r9 != 3) goto L76;
        r10 = ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_duplicate_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_duplicate_description");
        goto L126
    L76:
        throw new d.k();
    L80:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.q.f19609a) == false) goto L83;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_name_required, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_name_required"));
    L83:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.p.f19608a) == false) goto L86;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_name_invalid, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_name_invalid"));
    L86:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.c.f19595a) == false) goto L89;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_description_required, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_description_required"));
    L89:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.b.f19594a) == false) goto L92;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_body_required, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_body_required"));
    L92:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.impl.bt.r.class) == false) goto L95;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_name_invalid, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_name_invalid"));
    L95:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.aiagent.skill.manager.impl.bt.d.class) == false) goto L98;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_description_too_long, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_description_too_long"), new Object[]{Integer.valueOf(((com.obric.aiagent.skill.manager.impl.bt.d) ZeusTransformUtils.preCheckCast(r7.b(), com.obric.aiagent.skill.manager.impl.bt.d.class, "com.obric.aiagent.plugin")).b())});
    L98:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.t.f19612a) == false) goto L101;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_processing, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_processing"));
    L101:
        if (d.h.b.o.a(r0, com.obric.aiagent.skill.manager.impl.bt.j.f19602a) == false) goto L105;
        return a(ZeusTransformUtils.mapRes(R.string.obric_skill_file_failure_generic, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_file_failure_generic"));
    L105:
        throw new d.k();
    }

    private static final ah a(int r3) {
        return new ah(r3, null, 2, null);
    }

    private static final ah a(int r1, Object... r2) {
        return new ah(r1, d.a.i.g(r2));
    }

    private static final String a(long r7) {
        if (r7 < DownloadConstants.GB) goto L8;
        if ((r7 % DownloadConstants.GB) != 0) goto L8;
        return (r7 / DownloadConstants.GB) + " GB";
    L8:
        if (r7 < 1048576) goto L13;
        if ((r7 % 1048576) != 0) goto L13;
        return (r7 / 1048576) + " MB";
    L13:
        if (r7 < 1024) goto L18;
        if ((r7 % 1024) != 0) goto L18;
        return (r7 / 1024) + " KB";
    L18:
        return r7 + " B";
    }
}
