package com.stepos.ailauncher.chat.input.upload;

import La.H;
import Y8.j;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.utils.g;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import u6.C5578a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/chat/input/upload/a;", "", "<init>", "()V", "", "fileName", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)I", "", "EXT_TO_TYPE", "Ljava/util/Map;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final Map<String, Integer> EXT_TO_TYPE = kotlin.collections.a.m(j.a(ChatTracker.CONTENT_DOC, 3), j.a("docx", 3), j.a("docm", 3), j.a("dot", 3), j.a("dotx", 3), j.a("rtf", 3), j.a("odt", 3), j.a("pdf", 4), j.a("xls", 9), j.a("xlsx", 9), j.a("xlsm", 9), j.a("xlt", 9), j.a("xltx", 9), j.a("ods", 9), j.a("csv", 9), j.a(ChatTracker.CONTENT_PPT, 7), j.a("pptx", 7), j.a("pptm", 7), j.a("pps", 7), j.a("ppsx", 7), j.a("pot", 7), j.a("potx", 7), j.a("odp", 7), j.a("txt", 10), j.a("md", 11), j.a("markdown", 11), j.a("mp4", 2), j.a("mov", 2), j.a("mkv", 2), j.a("avi", 2), j.a("webm", 2), j.a("3gp", 2), j.a("png", 1), j.a(C5578a.DST_JPG, 1), j.a("jpeg", 1), j.a("gif", 1), j.a("webp", 1), j.a("bmp", 1), j.a("tif", 1), j.a("tiff", 1), j.a("heic", 1), j.a("heif", 1));

    public final int a(String fileName) {
        p.i(fileName, "fileName");
        String strQ1 = H.q1(fileName, '.', "");
        Locale ROOT = Locale.ROOT;
        p.h(ROOT, "ROOT");
        String lowerCase = strQ1.toLowerCase(ROOT);
        p.h(lowerCase, "toLowerCase(...)");
        Integer num = EXT_TO_TYPE.get(lowerCase);
        return num != null ? num.intValue() : g.INSTANCE.f(fileName);
    }
}
