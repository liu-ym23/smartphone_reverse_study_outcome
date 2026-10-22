package com.android.server.graphics.fonts;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontFileUtil;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.DirectByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.NioUtils;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
class OtfFontFileParser implements UpdatableFontDir.FontFileParser {
    OtfFontFileParser() {
    }

    @Override // com.android.server.graphics.fonts.UpdatableFontDir.FontFileParser
    public String getPostScriptName(File file) throws IOException {
        ByteBuffer buffer = mmap(file);
        String r1 = FontFileUtil.getPostScriptName(buffer, 0);     // Catch: Throwable -> L6
        unmap(buffer);
        return r1;
    L6:
        th = move-exception;
        unmap(buffer);
        throw th;
    }

    @Override // com.android.server.graphics.fonts.UpdatableFontDir.FontFileParser
    public String buildFontFileName(File file) throws IOException {
        ByteBuffer buffer = mmap(file);
        String psName = FontFileUtil.getPostScriptName(buffer, 0);     // Catch: Throwable -> L13
        int isType1Font = FontFileUtil.isPostScriptType1Font(buffer, 0);     // Catch: Throwable -> L13
        int isCollection = FontFileUtil.isCollectionFont(buffer);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(psName) == true) goto L25;
        if (isType1Font == (-1)) goto L25;
        if (isCollection == (-1)) goto L25;
        if (isCollection != 1) goto L18;
        if (isType1Font != 1) goto L15;
        String extension = ".otc";
    L22:
        String r5 = psName + extension;     // Catch: Throwable -> L13
        unmap(buffer);
        return r5;
    L15:
        extension = ".ttc";
        goto L22
    L18:
        if (isType1Font != 1) goto L20;
        extension = ".otf";
        goto L22
    L20:
        extension = ".ttf";
    L25:
        unmap(buffer);
        return null;
    L13:
        th = move-exception;
        unmap(buffer);
        throw th;
    }

    @Override // com.android.server.graphics.fonts.UpdatableFontDir.FontFileParser
    public long getRevision(File file) throws IOException {
        ByteBuffer buffer = mmap(file);
        long r1 = FontFileUtil.getRevision(buffer, 0);     // Catch: Throwable -> L6
        unmap(buffer);
        return r1;
    L6:
        th = move-exception;
        unmap(buffer);
        throw th;
    }

    @Override // com.android.server.graphics.fonts.UpdatableFontDir.FontFileParser
    public void tryToCreateTypeface(File file) throws Throwable {
        ByteBuffer buffer = mmap(file);
        Font font = new Font.Builder(buffer).build();     // Catch: Throwable -> L6
        FontFamily family = new FontFamily.Builder(font).build();     // Catch: Throwable -> L6
        Typeface typeface = new Typeface.CustomFallbackBuilder(family).build();     // Catch: Throwable -> L6
        TextPaint p = new TextPaint();     // Catch: Throwable -> L6
        p.setTextSize(24.0f);     // Catch: Throwable -> L6
        p.setTypeface(typeface);     // Catch: Throwable -> L6
        int width = (int) Math.ceil(Layout.getDesiredWidth("abcXYZ@- 🫖🇺🇸💏🏻👨🏼\u200d❤️\u200d💋\u200d👨🏿", p));     // Catch: Throwable -> L6
        StaticLayout layout = StaticLayout.Builder.obtain("abcXYZ@- 🫖🇺🇸💏🏻👨🏼\u200d❤️\u200d💋\u200d👨🏿", 0, "abcXYZ@- 🫖🇺🇸💏🏻👨🏼\u200d❤️\u200d💋\u200d👨🏿".length(), p, width).build();     // Catch: Throwable -> L6
        Bitmap bmp = Bitmap.createBitmap(layout.getWidth(), layout.getHeight(), Bitmap.Config.ALPHA_8);     // Catch: Throwable -> L6
        Canvas canvas = new Canvas(bmp);     // Catch: Throwable -> L6
        layout.draw(canvas);     // Catch: Throwable -> L6
        unmap(buffer);
        return;
    L6:
        th = move-exception;
        unmap(buffer);
        throw th;
    }

    private static ByteBuffer mmap(File file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        FileChannel fileChannel = in.getChannel();     // Catch: Throwable -> L6
        MappedByteBuffer r0 = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());     // Catch: Throwable -> L6
        in.close();
        return r0;
    L6:
        th = move-exception;
        in.close();     // Catch: Throwable -> L10
        throw th;
    L10:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    }

    private static void unmap(ByteBuffer buffer) {
        if ((buffer instanceof DirectByteBuffer) == false) goto L6;
        NioUtils.freeDirectBuffer(buffer);
        return;
    }
}
