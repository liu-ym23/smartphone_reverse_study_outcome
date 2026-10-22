package com.stepos.alphame.data.repo;

import F1.n;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b \u0010!J3\u0010\t\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ;\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0011j\b\u0012\u0004\u0012\u00028\u0000`\u0012\"\u0004\b\u0000\u0010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/stepos/alphame/data/repo/DailyUsageFileHelper;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, "", "fileName", "", "dataList", "saveListToFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;", "content", "saveStringToFile", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "path", "Ljava/lang/Class;", "clazz", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "readListFromFile", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/util/ArrayList;", "", "deleteFile", "(Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "LF1/n;", "gson", "LF1/n;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "<init>", "()V", "data_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class DailyUsageFileHelper {

    @NotNull
    private static final String TAG = "DailyUsageFileHelper";

    @NotNull
    public static final DailyUsageFileHelper INSTANCE = new DailyUsageFileHelper();

    @NotNull
    private static final n gson = new n();

    @NotNull
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private DailyUsageFileHelper() {
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0078  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0072 -> B:36:0x0070). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void deleteFile(@org.jetbrains.annotations.Nullable java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r7 = "DailyUsageFileHelper"
            if (r8 == 0) goto L88
            int r0 = r8.length()
            if (r0 != 0) goto Lc
            goto L88
        Lc:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = com.stepos.alphame.data.repo.DailyUsageFileHelper.lock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L1e
            int r2 = r0.getReadHoldCount()
            goto L1f
        L1e:
            r2 = r3
        L1f:
            r4 = r3
        L20:
            if (r4 >= r2) goto L28
            r1.unlock()
            int r4 = r4 + 1
            goto L20
        L28:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r4.<init>(r8)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            boolean r5 = r4.exists()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            if (r5 == 0) goto L56
            r4.delete()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r4.<init>()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.String r5 = "Deleted file: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r4.append(r8)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            android.util.Log.d(r7, r4)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            goto L70
        L52:
            r7 = move-exception
            goto L7c
        L54:
            r4 = move-exception
            goto L5c
        L56:
            java.lang.String r4 = "Deleted  no file"
            android.util.Log.d(r7, r4)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            goto L70
        L5c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
            r5.<init>()     // Catch: java.lang.Throwable -> L52
            java.lang.String r6 = "Error deleting file: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L52
            r5.append(r8)     // Catch: java.lang.Throwable -> L52
            java.lang.String r8 = r5.toString()     // Catch: java.lang.Throwable -> L52
            android.util.Log.e(r7, r8, r4)     // Catch: java.lang.Throwable -> L52
        L70:
            if (r3 >= r2) goto L78
            r1.lock()
            int r3 = r3 + 1
            goto L70
        L78:
            r0.unlock()
            return
        L7c:
            if (r3 >= r2) goto L84
            r1.lock()
            int r3 = r3 + 1
            goto L7c
        L84:
            r0.unlock()
            throw r7
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.data.repo.DailyUsageFileHelper.deleteFile(java.lang.String):void");
    }

    @NotNull
    public final <T> ArrayList<T> readListFromFile(@Nullable String path, @NotNull Class<T> clazz) {
        ArrayList<T> arrayList;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (path == null || path.length() == 0) {
            return new ArrayList<>();
        }
        ReentrantReadWriteLock.ReadLock lock2 = lock.readLock();
        lock2.lock();
        try {
            File file = new File(path);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            try {
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                arrayList = (ArrayList) gson.d(FilesKt.readText(file, UTF_8), TypeToken.getParameterized(ArrayList.class, clazz).getType());
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
            } catch (Exception e4) {
                Log.e(TAG, "Error reading file: " + path, e4);
                arrayList = new ArrayList<>();
            }
            return arrayList;
        } finally {
            lock2.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0093 A[DONT_GENERATE, LOOP:1: B:26:0x0091->B:27:0x0093, LOOP_END] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.String saveListToFile(@org.jetbrains.annotations.NotNull android.content.Context r9, @org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.NotNull java.util.List<? extends T> r11) {
        /*
            r8 = this;
            java.lang.String r8 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r8)
            java.lang.String r8 = "fileName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r8)
            java.lang.String r8 = "dataList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r8)
            boolean r8 = r11.isEmpty()
            r0 = 0
            if (r8 == 0) goto L17
            return r0
        L17:
            java.util.concurrent.locks.ReentrantReadWriteLock r8 = com.stepos.alphame.data.repo.DailyUsageFileHelper.lock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r8.readLock()
            int r2 = r8.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L29
            int r2 = r8.getReadHoldCount()
            goto L2a
        L29:
            r2 = r3
        L2a:
            r4 = r3
        L2b:
            if (r4 >= r2) goto L33
            r1.unlock()
            int r4 = r4 + 1
            goto L2b
        L33:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r8 = r8.writeLock()
            r8.lock()
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L70
            java.io.File r9 = r9.getFilesDir()     // Catch: java.lang.Throwable -> L70
            r4.<init>(r9, r10)     // Catch: java.lang.Throwable -> L70
            android.util.AtomicFile r9 = new android.util.AtomicFile     // Catch: java.lang.Throwable -> L70
            r9.<init>(r4)     // Catch: java.lang.Throwable -> L70
            F1.n r5 = com.stepos.alphame.data.repo.DailyUsageFileHelper.gson     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L74
            java.lang.String r11 = r5.g(r11)     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L74
            java.io.FileOutputStream r5 = r9.startWrite()     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L74
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L72
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L72
            java.lang.String r7 = "UTF_8"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L72
            byte[] r11 = r11.getBytes(r6)     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L72
            java.lang.String r6 = "getBytes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r6)     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L72
            r5.write(r11)     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L72
            r9.finishWrite(r5)     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L72
            java.lang.String r0 = r4.getAbsolutePath()     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L72
            goto L91
        L70:
            r9 = move-exception
            goto L9d
        L72:
            r11 = move-exception
            goto L76
        L74:
            r11 = move-exception
            r5 = r0
        L76:
            java.lang.String r4 = "DailyUsageFileHelper"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L70
            r6.<init>()     // Catch: java.lang.Throwable -> L70
            java.lang.String r7 = "Error saving file: "
            r6.append(r7)     // Catch: java.lang.Throwable -> L70
            r6.append(r10)     // Catch: java.lang.Throwable -> L70
            java.lang.String r10 = r6.toString()     // Catch: java.lang.Throwable -> L70
            android.util.Log.e(r4, r10, r11)     // Catch: java.lang.Throwable -> L70
            if (r5 == 0) goto L91
            r9.failWrite(r5)     // Catch: java.lang.Throwable -> L70
        L91:
            if (r3 >= r2) goto L99
            r1.lock()
            int r3 = r3 + 1
            goto L91
        L99:
            r8.unlock()
            return r0
        L9d:
            if (r3 >= r2) goto La5
            r1.lock()
            int r3 = r3 + 1
            goto L9d
        La5:
            r8.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.data.repo.DailyUsageFileHelper.saveListToFile(android.content.Context, java.lang.String, java.util.List):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0075 A[DONT_GENERATE, LOOP:1: B:28:0x0073->B:29:0x0075, LOOP_END] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String saveStringToFile(@org.jetbrains.annotations.NotNull android.content.Context r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.Nullable java.lang.String r10) {
        /*
            r7 = this;
            java.lang.String r7 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r7)
            java.lang.String r7 = "fileName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r7)
            r7 = 0
            if (r10 == 0) goto L8b
            int r0 = r10.length()
            if (r0 != 0) goto L15
            goto L8b
        L15:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = com.stepos.alphame.data.repo.DailyUsageFileHelper.lock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L27
            int r2 = r0.getReadHoldCount()
            goto L28
        L27:
            r2 = r3
        L28:
            r4 = r3
        L29:
            if (r4 >= r2) goto L31
            r1.unlock()
            int r4 = r4 + 1
            goto L29
        L31:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L65
            java.io.File r8 = r8.getFilesDir()     // Catch: java.lang.Throwable -> L65
            r4.<init>(r8, r9)     // Catch: java.lang.Throwable -> L65
            android.util.AtomicFile r8 = new android.util.AtomicFile     // Catch: java.lang.Throwable -> L65
            r8.<init>(r4)     // Catch: java.lang.Throwable -> L65
            java.io.FileOutputStream r9 = r8.startWrite()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L69
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
            java.lang.String r6 = "UTF_8"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
            byte[] r10 = r10.getBytes(r5)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
            java.lang.String r5 = "getBytes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r5)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
            r9.write(r10)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
            r8.finishWrite(r9)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
            java.lang.String r7 = r4.getAbsolutePath()     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
            goto L73
        L65:
            r7 = move-exception
            goto L7f
        L67:
            r10 = move-exception
            goto L6b
        L69:
            r10 = move-exception
            r9 = r7
        L6b:
            r10.printStackTrace()     // Catch: java.lang.Throwable -> L65
            if (r9 == 0) goto L73
            r8.failWrite(r9)     // Catch: java.lang.Throwable -> L65
        L73:
            if (r3 >= r2) goto L7b
            r1.lock()
            int r3 = r3 + 1
            goto L73
        L7b:
            r0.unlock()
            return r7
        L7f:
            if (r3 >= r2) goto L87
            r1.lock()
            int r3 = r3 + 1
            goto L7f
        L87:
            r0.unlock()
            throw r7
        L8b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.data.repo.DailyUsageFileHelper.saveStringToFile(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }
}
