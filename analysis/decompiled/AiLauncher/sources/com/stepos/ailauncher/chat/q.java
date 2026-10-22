package com.stepos.ailauncher.chat;

import Z8.Y;
import Z8.Z;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.zyql.ai.selector.compress.Checker;
import com.zyql.ai.selector.config.PictureMimeType;
import java.util.Set;
import kotlin.Metadata;
import u6.C5578a;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"SUPPORTED_IMAGE_MIME_TYPES", "", "", "[Ljava/lang/String;", "SUPPORTED_MIME_TYPES", "SUPPORTED_IMAGE_EXTENSIONS", "", "SUPPORTED_EXTENSIONS", "EXTRA_BIZ_TYPE", "EXTRA_IS_FROM_FAKE_MODE", "EXTRA_PIC_URI", "EXTRA_PICK_LIMIT", "ACTION_HIDE_FLOAT_WINDOW", "ACTION_RESHOW_FLOAT_WINDOW", "DEFAULT_COPY_BUFFER_SIZE", "", "PICK_IMAGE_MAX_COUNT", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class q {
    private static final String ACTION_HIDE_FLOAT_WINDOW = "com.stepos.ailauncher.ACTION_HIDE_FLOAT_WINDOW";
    private static final String ACTION_RESHOW_FLOAT_WINDOW = "com.stepos.ailauncher.ACTION_RESHOW_FLOAT_WINDOW";
    private static final int DEFAULT_COPY_BUFFER_SIZE = 8192;
    public static final String EXTRA_BIZ_TYPE = "extra_biz_type";
    public static final String EXTRA_IS_FROM_FAKE_MODE = "extra_is_from_fake_mode";
    public static final String EXTRA_PICK_LIMIT = "extra_pick_limit";
    public static final String EXTRA_PIC_URI = "remote_uri";
    private static final int PICK_IMAGE_MAX_COUNT = 10;
    private static final Set<String> SUPPORTED_EXTENSIONS;
    private static final Set<String> SUPPORTED_IMAGE_EXTENSIONS;
    private static final String[] SUPPORTED_IMAGE_MIME_TYPES;
    private static final String[] SUPPORTED_MIME_TYPES;

    static {
        String[] strArr = {"image/jpeg", PictureMimeType.PNG_Q, "image/webp", "image/gif", "image/tiff", Checker.MIME_TYPE_HEIC, "image/heif"};
        SUPPORTED_IMAGE_MIME_TYPES = strArr;
        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x(35);
        xVar.b(strArr);
        xVar.a("text/x-markdown");
        xVar.a("text/markdown");
        xVar.a(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30839B);
        xVar.a("application/pdf");
        xVar.a("application/msword");
        xVar.a("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        xVar.a("application/vnd.ms-word.document.macroenabled.12");
        xVar.a("application/vnd.openxmlformats-officedocument.wordprocessingml.template");
        xVar.a("application/rtf");
        xVar.a("application/vnd.oasis.opendocument.text");
        xVar.a("application/vnd.ms-excel");
        xVar.a("application/x-excel");
        xVar.a("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        xVar.a("application/vnd.ms-excel.sheet.macroenabled.12");
        xVar.a("application/vnd.openxmlformats-officedocument.spreadsheetml.template");
        xVar.a("application/vnd.oasis.opendocument.spreadsheet");
        xVar.a("application/vnd.ms-powerpoint");
        xVar.a("application/vnd.openxmlformats-officedocument.presentationml.presentation");
        xVar.a("application/vnd.ms-powerpoint.presentation.macroenabled.12");
        xVar.a("application/vnd.openxmlformats-officedocument.presentationml.slideshow");
        xVar.a("application/vnd.openxmlformats-officedocument.presentationml.template");
        xVar.a("application/vnd.oasis.opendocument.presentation");
        xVar.a("application/epub+zip");
        xVar.a("text/csv");
        xVar.a("application/csv");
        xVar.a("text/xml");
        xVar.a("application/xml");
        xVar.a("application/json");
        xVar.a("text/tab-separated-values");
        xVar.a("application/x-yaml");
        xVar.a("application/yaml");
        xVar.a("text/yaml");
        xVar.a("text/x-yaml");
        xVar.a("text/html");
        SUPPORTED_MIME_TYPES = (String[]) xVar.d(new String[xVar.c()]);
        Set<String> setJ = Y.j(C5578a.DST_JPG, "jpeg", "png", "webp", "gif", "tif", "tiff", "heic", "heif");
        SUPPORTED_IMAGE_EXTENSIONS = setJ;
        SUPPORTED_EXTENSIONS = Z.o(setJ, Y.j("txt", "md", "markdown", "pdf", ChatTracker.CONTENT_DOC, "docx", "docm", "dot", "dotx", "rtf", "odt", "xls", "xlsx", "xlsm", "xlt", "xltx", "ods", ChatTracker.CONTENT_PPT, "pptx", "pptm", "pps", "ppsx", "pot", "potx", "odp", "epub", "csv", "tsv", "xml", "json", "yaml", "yml", "htm", "html"));
    }
}
