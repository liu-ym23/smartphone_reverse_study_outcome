package com.android.server.graphics.fonts;

import android.content.Context;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontUpdateRequest;
import android.graphics.fonts.FontVariationAxis;
import android.graphics.fonts.SystemFonts;
import android.os.Binder;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.ShellCommand;
import android.text.FontConfig;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.DumpUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.server.am.HostingRecord;
import com.android.server.wm.ActivityTaskManagerService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

/* JADX INFO: loaded from: classes2.dex */
public class FontManagerShellCommand extends ShellCommand {
    private static final int MAX_SIGNATURE_FILE_SIZE_BYTES = 8192;
    private static final String TAG = "FontManagerShellCommand";
    private final FontManagerService mService;

    FontManagerShellCommand(FontManagerService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        int callingUid = Binder.getCallingUid();
        if (callingUid == 0) goto L9;
        if (callingUid == 2000) goto L9;
        getErrPrintWriter().println("Only shell or root user can execute font command.");
        return 1;
    L9:
        return execCommand(this, cmd);
    }

    public void onHelp() {
        PrintWriter w = getOutPrintWriter();
        w.println("Font service (font) commands");
        w.println("help");
        w.println("    Print this help text.");
        w.println();
        w.println("dump [family name]");
        w.println("    Dump all font files in the specified family name.");
        w.println("    Dump current system font configuration if no family name was specified.");
        w.println();
        w.println("update [font file path] [signature file path]");
        w.println("    Update installed font files with new font file.");
        w.println();
        w.println("update-family [family definition XML path]");
        w.println("    Update font families with the new definitions.");
        w.println();
        w.println("install-debug-cert [cert file path]");
        w.println("    Install debug certificate file. This command can be used only on");
        w.println("    debuggable device with root user.");
        w.println();
        w.println("clear");
        w.println("    Remove all installed font files and reset to the initial state.");
        w.println();
        w.println(HostingRecord.HOSTING_TYPE_RESTART);
        w.println("    Restart FontManagerService emulating device reboot.");
        w.println("    WARNING: this is not a safe operation. Other processes may misbehave if");
        w.println("    they are using fonts updated by FontManagerService.");
        w.println("    This command exists merely for testing.");
        w.println();
        w.println("status");
        w.println("    Prints status of current system font configuration.");
    }

    void dumpAll(IndentingPrintWriter w) {
        FontConfig fontConfig = this.mService.getSystemFontConfig();
        dumpFontConfig(w, fontConfig);
    }

    private void dumpSingleFontConfig(IndentingPrintWriter w, FontConfig.Font font) {
        StringBuilder sb = new StringBuilder();
        sb.append("style = ");
        sb.append(font.getStyle());
        sb.append(", path = ");
        sb.append(font.getFile().getAbsolutePath());
        if (font.getTtcIndex() == 0) goto L6;
        sb.append(", index = ");
        sb.append(font.getTtcIndex());
    L6:
        if (font.getFontVariationSettings().isEmpty() == true) goto L9;
        sb.append(", axes = ");
        sb.append(font.getFontVariationSettings());
    L9:
        if (font.getFontFamilyName() == null) goto L11;
        sb.append(", fallback = ");
        sb.append(font.getFontFamilyName());
    L11:
        w.println(sb.toString());
        if (font.getOriginalFile() == null) goto L15;
        w.increaseIndent();
        w.println("Font is updated from " + font.getOriginalFile());
        w.decreaseIndent();
        return;
    }

    private void dumpFontConfig(IndentingPrintWriter w, FontConfig fontConfig) {
        List<FontConfig.FontFamily> families = fontConfig.getFontFamilies();
        w.println("Named Family List");
        w.increaseIndent();
        List<FontConfig.NamedFamilyList> namedFamilyLists = fontConfig.getNamedFamilyLists();
        int i = 0;
    L4:
        if (i >= namedFamilyLists.size()) goto L14;
        FontConfig.NamedFamilyList namedFamilyList = namedFamilyLists.get(i);
        w.println("Named Family (" + namedFamilyList.getName() + ")");
        w.increaseIndent();
        List<FontConfig.FontFamily> namedFamilies = namedFamilyList.getFamilies();
        int j = 0;
    L7:
        if (j >= namedFamilies.size()) goto L13;
        FontConfig.FontFamily family = namedFamilies.get(j);
        w.println("Family");
        List<FontConfig.Font> fonts = family.getFontList();
        w.increaseIndent();
        int k = 0;
    L10:
        if (k >= fonts.size()) goto L12;
        dumpSingleFontConfig(w, fonts.get(k));
        k = k + 1;
        goto L10
    L12:
        w.decreaseIndent();
        j = j + 1;
        goto L7
    L13:
        w.decreaseIndent();
        i = i + 1;
        goto L4
    L14:
        w.decreaseIndent();
        w.println("Dump Fallback Families");
        w.increaseIndent();
        int c = 0;
        int i2 = 0;
    L16:
        if (i2 >= families.size()) goto L33;
        FontConfig.FontFamily family2 = families.get(i2);
        if (family2.getName() != null) goto L32;
        StringBuilder sb = new StringBuilder("Fallback Family [");
        int c2 = c + 1;
        sb.append(c);
        sb.append("]: lang=\"");
        sb.append(family2.getLocaleList().toLanguageTags());
        sb.append("\"");
        if (family2.getVariant() == 0) goto L27;
        sb.append(", variant=");
        switch(family2.getVariant()) {
            case 1: goto L26;
            case 2: goto L25;
            default: goto L24;
        };
    L24:
        sb.append("Unknown");
        goto L27
    L25:
        sb.append("Elegant");
        goto L27
    L26:
        sb.append("Compact");
    L27:
        w.println(sb.toString());
        List<FontConfig.Font> fonts2 = family2.getFontList();
        w.increaseIndent();
        int j2 = 0;
    L29:
        if (j2 >= fonts2.size()) goto L31;
        dumpSingleFontConfig(w, fonts2.get(j2));
        j2 = j2 + 1;
        goto L29
    L31:
        w.decreaseIndent();
        c = c2;
    L32:
        i2 = i2 + 1;
        goto L16
    L33:
        w.decreaseIndent();
        w.println("Dump Family Aliases");
        w.increaseIndent();
        List<FontConfig.Alias> aliases = fontConfig.getAliases();
        int i3 = 0;
    L35:
        if (i3 >= aliases.size()) goto L37;
        FontConfig.Alias alias = aliases.get(i3);
        w.println("alias = " + alias.getName() + ", reference = " + alias.getOriginal() + ", width = " + alias.getWeight());
        i3 = i3 + 1;
        goto L35
    L37:
        w.decreaseIndent();
    }

    private void dumpFallback(IndentingPrintWriter writer, FontFamily[] families) {
        int r0 = families.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        FontFamily family = families[r1];
        dumpFamily(writer, family);
        r1 = r1 + 1;
        goto L3
    }

    private void dumpFamily(IndentingPrintWriter writer, FontFamily family) {
        StringBuilder sb = new StringBuilder("Family:");
        if (family.getLangTags() == null) goto L6;
        sb.append(" langTag = ");
        sb.append(family.getLangTags());
    L6:
        if (family.getVariant() == 0) goto L12;
        sb.append(" variant = ");
        switch(family.getVariant()) {
            case 1: goto L11;
            case 2: goto L10;
            default: goto L9;
        };
    L9:
        sb.append("UNKNOWN");
        goto L12
    L10:
        sb.append("Elegant");
        goto L12
    L11:
        sb.append("Compact");
    L12:
        writer.println(sb.toString());
        int i = 0;
    L14:
        if (i >= family.getSize()) goto L22;
        writer.increaseIndent();
        dumpFont(writer, family.getFont(i));     // Catch: Throwable -> L18
        writer.decreaseIndent();
        i = i + 1;
    L18:
        th = move-exception;
        writer.decreaseIndent();
        throw th;
    }

    private void dumpFont(IndentingPrintWriter writer, Font font) {
        File file = font.getFile();
        StringBuilder sb = new StringBuilder();
        sb.append(font.getStyle());
        sb.append(", path = ");
        if (file != null) goto L5;
        String r2 = "[Not a file]";
    L6:
        sb.append(r2);
        if (font.getTtcIndex() == 0) goto L9;
        sb.append(", index = ");
        sb.append(font.getTtcIndex());
    L9:
        FontVariationAxis[] axes = font.getAxes();
        if (axes != null) goto L12;
    L14:
        writer.println(sb.toString());
        return;
    L12:
        if (axes.length == 0) goto L14;
        sb.append(", axes = \"");
        sb.append(FontVariationAxis.toFontVariationSettings(axes));
        sb.append("\"");
        goto L14
    L5:
        r2 = file.getAbsolutePath();
        goto L6
    }

    private void writeCommandResult(ShellCommand shell, FontManagerService.SystemFontException e) {
        PrintWriter pw = shell.getErrPrintWriter();
        pw.println(e.getErrorCode());
        pw.println(e.getMessage());
        Slog.e(TAG, "Command failed: " + Arrays.toString(shell.getAllArgs()), e);
    }

    private int dump(ShellCommand shell) {
        Context ctx = this.mService.getContext();
        if (DumpUtils.checkDumpPermission(ctx, TAG, shell.getErrPrintWriter()) == true) goto L6;
        return 1;
    L6:
        IndentingPrintWriter writer = new IndentingPrintWriter(shell.getOutPrintWriter(), "  ");
        String nextArg = shell.getNextArg();
        FontConfig fontConfig = this.mService.getSystemFontConfig();
        if (nextArg != null) goto L9;
        dumpFontConfig(writer, fontConfig);
        return 0;
    L9:
        Map<String, FontFamily[]> fallbackMap = SystemFonts.buildSystemFallback(fontConfig);
        FontFamily[] families = fallbackMap.get(nextArg);
        if (families != null) goto L12;
        writer.println("Font Family \"" + nextArg + "\" not found");
        return 0;
    L12:
        dumpFallback(writer, families);
        return 0;
    }

    private int installCert(ShellCommand shell) throws FontManagerService.SystemFontException {
        if (Build.IS_DEBUGGABLE == false) goto L19;
        if (Binder.getCallingUid() != 0) goto L17;
        String certPath = shell.getNextArg();
        if (certPath == null) goto L15;
        File file = new File(certPath);
        if (file.isFile() == false) goto L13;
        this.mService.addDebugCertificate(certPath);
        this.mService.restart();
        shell.getOutPrintWriter().println("Success");
        return 0;
    L13:
        throw new FontManagerService.SystemFontException(-10008, "Cert file (" + file + ") is not found");
    L15:
        throw new FontManagerService.SystemFontException(-10008, "Cert file path argument is required.");
    L17:
        throw new SecurityException("Only root can add debug certificate");
    L19:
        throw new SecurityException("Only debuggable device can add debug certificate");
    }

    private int update(ShellCommand shell) throws FontManagerService.SystemFontException {
        String fontPath = shell.getNextArg();
        if (fontPath == null) goto L67;
        String signaturePath = shell.getNextArg();
        if (signaturePath == null) goto L65;
        ParcelFileDescriptor fontFd = shell.openFileForSystem(fontPath, ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD);     // Catch: IOException -> L22
        ParcelFileDescriptor sigFd = shell.openFileForSystem(signaturePath, ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD);     // Catch: Throwable -> L24
        if (fontFd == null) goto L47;
        if (sigFd == null) goto L45;
        FileInputStream sigFis = new FileInputStream(sigFd.getFileDescriptor());     // Catch: Throwable -> L26 IOException -> L28
        int len = sigFis.available();     // Catch: Throwable -> L32
        if (len > 8192) goto L35;
        byte[] signature = new byte[len];     // Catch: Throwable -> L32
        if (sigFis.read(signature, 0, len) != len) goto L31;
        sigFis.close();     // Catch: Throwable -> L26 IOException -> L28
        this.mService.update(-1, Collections.singletonList(new FontUpdateRequest(fontFd, signature)));     // Catch: Throwable -> L26
        sigFd.close();     // Catch: Throwable -> L24
        fontFd.close();     // Catch: IOException -> L22
    L62:
        shell.getOutPrintWriter().println("Success");
        return 0;
    L31:
        throw new FontManagerService.SystemFontException(-10004, "Invalid read length");     // Catch: Throwable -> L32
    L35:
        throw new FontManagerService.SystemFontException(-10005, "Signature file is too large");     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        sigFis.close();     // Catch: Throwable -> L38
    L40:
        throw th;     // Catch: Throwable -> L26 IOException -> L28
    L38:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L26 IOException -> L28
    L28:
        e = move-exception;
        throw new FontManagerService.SystemFontException(-10004, "Failed to read signature file.", e);     // Catch: Throwable -> L26
    L45:
        throw new FontManagerService.SystemFontException(-10002, "Failed to open signature file");     // Catch: Throwable -> L26
    L47:
        throw new FontManagerService.SystemFontException(-10001, "Failed to open font file");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        if (sigFd != null) goto L77;
    L53:
        throw th;     // Catch: Throwable -> L24
    L77:
        sigFd.close();     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        if (fontFd != null) goto L73;
    L60:
        throw th;     // Catch: IOException -> L22
    L73:
        fontFd.close();     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L22
    L22:
        e = move-exception;
        Slog.w(TAG, "Error while closing files", e);
        goto L62
    L65:
        throw new FontManagerService.SystemFontException(-10003, "Signature file argument is required.");
    L67:
        throw new FontManagerService.SystemFontException(-10003, "Font file path argument is required.");
    }

    private int updateFamily(ShellCommand shell) throws FontManagerService.SystemFontException {
        String xmlPath = shell.getNextArg();
        if (xmlPath == null) goto L22;
        ParcelFileDescriptor xmlFd = shell.openFileForSystem(xmlPath, ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD);     // Catch: IOException -> L9
        List<FontUpdateRequest> requests = parseFontFamilyUpdateXml(new FileInputStream(xmlFd.getFileDescriptor()));     // Catch: Throwable -> L11
        xmlFd.close();     // Catch: IOException -> L9
        this.mService.update(-1, requests);
        shell.getOutPrintWriter().println("Success");
        return 0;
    L11:
        th = move-exception;
        if (xmlFd != null) goto L25;
    L18:
        throw th;     // Catch: IOException -> L9
    L25:
        xmlFd.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L9
    L9:
        e = move-exception;
        throw new FontManagerService.SystemFontException(-10006, "Failed to open XML file.", e);
    L22:
        throw new FontManagerService.SystemFontException(-10003, "XML file path argument is required.");
    }

    private static List<FontUpdateRequest> parseFontFamilyUpdateXml(InputStream inputStream) throws FontManagerService.SystemFontException {
        TypedXmlPullParser parser = Xml.resolvePullParser(inputStream);     // Catch: Throwable -> L15
        List<FontUpdateRequest> requests = new ArrayList();     // Catch: Throwable -> L15
    L3:
        int type = parser.next();     // Catch: Throwable -> L15
        if (type == 1) goto L24;
        if (type != 2) goto L3;
        int depth = parser.getDepth();     // Catch: Throwable -> L15
        String tag = parser.getName();     // Catch: Throwable -> L15
        if (depth == 1) goto L11;
        if (depth != 2) goto L3;
        if ("family".equals(tag) == false) goto L22;
        requests.add(new FontUpdateRequest(FontUpdateRequest.Family.readFromXml(parser)));     // Catch: Throwable -> L15
        goto L3
    L22:
        throw new FontManagerService.SystemFontException(-10007, "Expected <family> but got: " + tag);     // Catch: Throwable -> L15
    L11:
        if ("fontFamilyUpdateRequest".equals(tag) == true) goto L3;
        throw new FontManagerService.SystemFontException(-10007, "Expected <fontFamilyUpdateRequest> but got: " + tag);     // Catch: Throwable -> L15
    L24:
        return requests;
    L15:
        e = move-exception;
        throw new FontManagerService.SystemFontException(0, "Failed to parse xml", e);
    }

    private int clear(ShellCommand shell) {
        this.mService.clearUpdates();
        shell.getOutPrintWriter().println("Success");
        return 0;
    }

    private int restart(ShellCommand shell) {
        this.mService.restart();
        shell.getOutPrintWriter().println("Success");
        return 0;
    }

    private int status(ShellCommand shell) {
        IndentingPrintWriter writer = new IndentingPrintWriter(shell.getOutPrintWriter(), "  ");
        FontConfig config = this.mService.getSystemFontConfig();
        writer.println("Current Version: " + config.getConfigVersion());
        LocalDateTime dt = LocalDateTime.ofEpochSecond(config.getLastModifiedTimeMillis(), 0, ZoneOffset.UTC);
        writer.println("Last Modified Date: " + dt.format(DateTimeFormatter.ISO_DATE_TIME));
        Map<String, File> fontFileMap = this.mService.getFontFileMap();
        writer.println("Number of updated font files: " + fontFileMap.size());
        return 0;
    }

    private int execCommand(ShellCommand shell, String cmd) {
        if (cmd != null) goto L52;
        return shell.handleDefaultCommands(null);
    L52:
    L12:
        e = move-exception;
        writeCommandResult(shell, e);
        return 1;
    L7:
        switch(cmd.hashCode()) {
            case -2084349744: goto L30;
            case -892481550: goto L27;
            case -838846263: goto L24;
            case 3095028: goto L21;
            case 94746189: goto L18;
            case 1097506319: goto L15;
            case 1135462632: goto L10;
            default: goto L32;
        };     // Catch: FontManagerService.SystemFontException -> L12
    L32:
        byte r1 = -1;
    L33:
        switch(r1) {
            case 0: goto L49;
            case 1: goto L47;
            case 2: goto L45;
            case 3: goto L43;
            case 4: goto L41;
            case 5: goto L39;
            case 6: goto L37;
            default: goto L35;
        };     // Catch: FontManagerService.SystemFontException -> L12
    L35:
        return shell.handleDefaultCommands(cmd);
    L37:
        return installCert(shell);
    L39:
        return status(shell);
    L41:
        return restart(shell);
    L43:
        return clear(shell);
    L45:
        return updateFamily(shell);
    L47:
        return update(shell);
    L49:
        return dump(shell);
    L10:
        if (cmd.equals("update-family") == false) goto L32;
        r1 = 2;
        goto L33
    L15:
        if (cmd.equals(HostingRecord.HOSTING_TYPE_RESTART) == false) goto L32;
        r1 = 4;
        goto L33
    L18:
        if (cmd.equals("clear") == false) goto L32;
        r1 = 3;
        goto L33
    L21:
        if (cmd.equals(ArchiveStreamFactory.DUMP) == false) goto L32;
        r1 = 0;
        goto L33
    L24:
        if (cmd.equals("update") == false) goto L32;
        r1 = 1;
        goto L33
    L27:
        if (cmd.equals("status") == false) goto L32;
        r1 = 5;
        goto L33
    L30:
        if (cmd.equals("install-debug-cert") == false) goto L32;
        r1 = 6;
        goto L33
    }
}
