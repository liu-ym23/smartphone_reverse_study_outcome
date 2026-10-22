package com.android.server.usb.descriptors.report;

import com.android.server.am.SettingsToPropertiesMapper;
import com.android.server.usb.descriptors.UsbDescriptorParser;

/* JADX INFO: loaded from: classes3.dex */
public final class TextReportCanvas extends ReportCanvas {
    private static final int LIST_INDENT_AMNT = 2;
    private static final String TAG = "TextReportCanvas";
    private int mListIndent;
    private final StringBuilder mStringBuilder;

    public TextReportCanvas(UsbDescriptorParser parser, StringBuilder stringBuilder) {
        super(parser);
        this.mStringBuilder = stringBuilder;
    }

    private void writeListIndent() {
        int space = 0;
    L4:
        if (space >= this.mListIndent) goto L7;
        this.mStringBuilder.append(" ");
        space = space + 1;
        goto L4
    }

    @Override // com.android.server.usb.descriptors.report.ReportCanvas
    public void write(String text) {
        this.mStringBuilder.append(text);
    }

    @Override // com.android.server.usb.descriptors.report.ReportCanvas
    public void openHeader(int level) {
        writeListIndent();
        this.mStringBuilder.append("[");
    }

    @Override // com.android.server.usb.descriptors.report.ReportCanvas
    public void closeHeader(int level) {
        this.mStringBuilder.append("]\n");
    }

    @Override // com.android.server.usb.descriptors.report.ReportCanvas
    public void openParagraph(boolean emphasis) {
        writeListIndent();
    }

    @Override // com.android.server.usb.descriptors.report.ReportCanvas
    public void closeParagraph() {
        this.mStringBuilder.append("\n");
    }

    @Override // com.android.server.usb.descriptors.report.ReportCanvas
    public void writeParagraph(String text, boolean inRed) {
        openParagraph(inRed);
        if (inRed == false) goto L5;
        this.mStringBuilder.append(SettingsToPropertiesMapper.NAMESPACE_REBOOT_STAGING_DELIMITER + text + SettingsToPropertiesMapper.NAMESPACE_REBOOT_STAGING_DELIMITER);
    L6:
        closeParagraph();
        return;
    L5:
        this.mStringBuilder.append(text);
        goto L6
    }

    @Override // com.android.server.usb.descriptors.report.ReportCanvas
    public void openList() {
        this.mListIndent += 2;
    }

    @Override // com.android.server.usb.descriptors.report.ReportCanvas
    public void closeList() {
        this.mListIndent -= 2;
    }

    @Override // com.android.server.usb.descriptors.report.ReportCanvas
    public void openListItem() {
        writeListIndent();
        this.mStringBuilder.append("- ");
    }

    @Override // com.android.server.usb.descriptors.report.ReportCanvas
    public void closeListItem() {
        this.mStringBuilder.append("\n");
    }
}
