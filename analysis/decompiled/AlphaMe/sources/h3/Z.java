package h3;

import com.stepos.alphame.app.AppEventDataItem;
import java.io.File;
import k3.InterfaceC0695j;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public abstract class Z {

    @NotNull
    public static final Y Companion = new Y();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
    @JvmStatic
    @NotNull
    public static final Z create(@Nullable M m4, @NotNull File file) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(file, "<this>");
        return new W(m4, file, 0);
    }

    public abstract long contentLength();

    public abstract M contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(InterfaceC0695j interfaceC0695j);

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    @NotNull
    public static final Z create(@Nullable M m4, @NotNull String content) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(content, "content");
        return Y.a(content, m4);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    @NotNull
    public static final Z create(@Nullable M m4, @NotNull k3.l content) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(content, "<this>");
        return new W(m4, content, 1);
    }

    @JvmStatic
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmOverloads
    public static final Z create(@Nullable M m4, @NotNull byte[] content) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(content, "content");
        int length = content.length;
        Intrinsics.checkNotNullParameter(content, "content");
        return Y.b(content, m4, 0, length);
    }

    @JvmStatic
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmOverloads
    public static final Z create(@Nullable M m4, @NotNull byte[] content, int i4) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(content, "content");
        int length = content.length;
        Intrinsics.checkNotNullParameter(content, "content");
        return Y.b(content, m4, i4, length);
    }

    @JvmStatic
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmOverloads
    public static final Z create(@Nullable M m4, @NotNull byte[] content, int i4, int i5) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(content, "content");
        return Y.b(content, m4, i4, i5);
    }

    @JvmStatic
    @JvmName(name = AppEventDataItem.APP_CREATE)
    @NotNull
    public static final Z create(@NotNull File file, @Nullable M m4) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(file, "<this>");
        return new W(m4, file, 0);
    }

    @JvmStatic
    @JvmName(name = AppEventDataItem.APP_CREATE)
    @NotNull
    public static final Z create(@NotNull String str, @Nullable M m4) {
        Companion.getClass();
        return Y.a(str, m4);
    }

    @JvmStatic
    @JvmName(name = AppEventDataItem.APP_CREATE)
    @NotNull
    public static final Z create(@NotNull k3.l lVar, @Nullable M m4) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        return new W(m4, lVar, 1);
    }

    @JvmStatic
    @JvmName(name = AppEventDataItem.APP_CREATE)
    @NotNull
    @JvmOverloads
    public static final Z create(@NotNull byte[] bArr) {
        Y y4 = Companion;
        y4.getClass();
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return Y.c(y4, bArr, null, 0, 7);
    }

    @JvmStatic
    @JvmName(name = AppEventDataItem.APP_CREATE)
    @NotNull
    @JvmOverloads
    public static final Z create(@NotNull byte[] bArr, @Nullable M m4) {
        Y y4 = Companion;
        y4.getClass();
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return Y.c(y4, bArr, m4, 0, 6);
    }

    @JvmStatic
    @JvmName(name = AppEventDataItem.APP_CREATE)
    @NotNull
    @JvmOverloads
    public static final Z create(@NotNull byte[] bArr, @Nullable M m4, int i4) {
        Y y4 = Companion;
        y4.getClass();
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return Y.c(y4, bArr, m4, i4, 4);
    }

    @JvmStatic
    @JvmName(name = AppEventDataItem.APP_CREATE)
    @NotNull
    @JvmOverloads
    public static final Z create(@NotNull byte[] bArr, @Nullable M m4, int i4, int i5) {
        Companion.getClass();
        return Y.b(bArr, m4, i4, i5);
    }
}
