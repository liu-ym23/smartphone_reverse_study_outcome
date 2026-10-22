package com.stepos.alphame.dailyusage;

import B0.g;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.ApplicationImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bJ\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\bH\u0016J$\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016JO\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0005\u001a\u00020\u00062\u0010\u0010\u001e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\bJ;\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\nH\u0016¢\u0006\u0002\u0010&¨\u0006("}, d2 = {"Lcom/stepos/alphame/dailyusage/DailyUsageContentProvider;", "Landroid/content/ContentProvider;", "()V", "delete", "", "uri", "Landroid/net/Uri;", "selection", "", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getFileDescriptor", "Landroid/os/ParcelFileDescriptor;", "getType", "insert", "values", "Landroid/content/ContentValues;", "isStringSizeOver1MB", "", "inputString", "onCreate", "openAssetFile", "Landroid/content/res/AssetFileDescriptor;", "mode", "openFile", "signal", "Landroid/os/CancellationSignal;", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "saveJsonAndGetUriString", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "content", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDailyUsageContentProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DailyUsageContentProvider.kt\ncom/stepos/alphame/dailyusage/DailyUsageContentProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,185:1\n1#2:186\n*E\n"})
/* loaded from: classes.dex */
public final class DailyUsageContentProvider extends ContentProvider {

    @NotNull
    public static final String AUTHORITY = "com.stepos.alphame.dailyusage.provider";
    public static final int CODE_MULTI_SUMMARY = 1;
    public static final int CODE_MULTI_SUMMARY_FOR_BIG_DATA = 2;

    @NotNull
    public static final String COLUMN_RESULT_JSON = "result_json";

    @NotNull
    public static final String PATH_MULTI_SUMMARY = "multi_daily_usage_summary";

    @NotNull
    public static final String PATH_MULTI_SUMMARY_FOR_BIG_DATA = "multi_daily_usage_summary_for_big_data";

    @NotNull
    public static final String TAG = "DailyUsageContentProvider";

    @NotNull
    private static final ReentrantReadWriteLock rwLock;

    @NotNull
    private static final UriMatcher uriMatcher;

    static {
        UriMatcher uriMatcher2 = new UriMatcher(-1);
        uriMatcher2.addURI(AUTHORITY, PATH_MULTI_SUMMARY, 1);
        uriMatcher2.addURI(AUTHORITY, PATH_MULTI_SUMMARY_FOR_BIG_DATA, 2);
        uriMatcher = uriMatcher2;
        rwLock = new ReentrantReadWriteLock();
    }

    private final ParcelFileDescriptor getFileDescriptor(Uri uri) throws FileNotFoundException {
        Log.d(TAG, "process URI: " + uri);
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            throw new FileNotFoundException("URI is null");
        }
        Context context = getContext();
        File file = new File(context != null ? context.getFilesDir() : null, lastPathSegment);
        if (file.exists()) {
            ParcelFileDescriptor parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, SQLiteDatabase.CREATE_IF_NECESSARY);
            Intrinsics.checkNotNullExpressionValue(parcelFileDescriptorOpen, "open(...)");
            return parcelFileDescriptorOpen;
        }
        Log.e(TAG, "file don't exist: " + file.getAbsolutePath());
        throw new FileNotFoundException(g.m("File not found at: ", file.getAbsolutePath()));
    }

    @Override // android.content.ContentProvider
    public int delete(@NotNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NotNull Uri uri, @Nullable ContentValues values) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    public final boolean isStringSizeOver1MB(@NotNull String inputString) {
        Intrinsics.checkNotNullParameter(inputString, "inputString");
        byte[] bytes = inputString.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes.length > 1048576;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public AssetFileDescriptor openAssetFile(@NotNull Uri uri, @NotNull String mode) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(mode, "mode");
        ParcelFileDescriptor fileDescriptor = getFileDescriptor(uri);
        if (fileDescriptor != null) {
            return new AssetFileDescriptor(fileDescriptor, 0L, -1L);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public ParcelFileDescriptor openFile(@NotNull Uri uri, @NotNull String mode) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return getFileDescriptor(uri);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        int iMatch = uriMatcher.match(uri);
        if (iMatch == 1) {
            Log.d(TAG, "start query normal data    " + System.currentTimeMillis());
            if (selectionArgs == null || selectionArgs.length < 5) {
                Log.e("DailyUsageProvider", "Invalid arguments");
                return null;
            }
            try {
                String multiDailyUsageSummary = DailyUsageEngineService.INSTANCE.getINSTANCE().getMultiDailyUsageSummary(Integer.parseInt(selectionArgs[0]), Long.parseLong(selectionArgs[1]), Long.parseLong(selectionArgs[2]), Long.parseLong(selectionArgs[3]), Long.parseLong(selectionArgs[4]));
                if (isStringSizeOver1MB(multiDailyUsageSummary)) {
                    return null;
                }
                MatrixCursor matrixCursor = new MatrixCursor(new String[]{COLUMN_RESULT_JSON});
                matrixCursor.addRow(new String[]{multiDailyUsageSummary});
                Log.d(TAG, "return cursor is " + matrixCursor + "    " + System.currentTimeMillis());
                return matrixCursor;
            } catch (Exception e4) {
                e4.printStackTrace();
                Log.e(TAG, "return cursor fail " + e4 + "    " + System.currentTimeMillis());
                return null;
            }
        }
        if (iMatch != 2) {
            Log.e(TAG, "Unknown URI: " + uri);
            return null;
        }
        Log.d(TAG, "Querying big data summary " + System.currentTimeMillis());
        if (selectionArgs == null || selectionArgs.length < 5) {
            Log.e("DailyUsageProvider", "Invalid arguments");
            return null;
        }
        try {
            String multiDailyUsageSummary2 = DailyUsageEngineService.INSTANCE.getINSTANCE().getMultiDailyUsageSummary(Integer.parseInt(selectionArgs[0]), Long.parseLong(selectionArgs[1]), Long.parseLong(selectionArgs[2]), Long.parseLong(selectionArgs[3]), Long.parseLong(selectionArgs[4]));
            Context applicationContext = ApplicationImpl.getApplication().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            String strSaveJsonAndGetUriString = saveJsonAndGetUriString(applicationContext, multiDailyUsageSummary2);
            MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{COLUMN_RESULT_JSON});
            matrixCursor2.addRow(new String[]{strSaveJsonAndGetUriString});
            Log.d(TAG, "return cursor is " + matrixCursor2 + "   " + System.currentTimeMillis());
            return matrixCursor2;
        } catch (Exception e5) {
            e5.printStackTrace();
            Log.e(TAG, "return cursor fail " + e5 + "    " + System.currentTimeMillis());
            return null;
        }
    }

    @NotNull
    public final String saveJsonAndGetUriString(@NotNull Context context, @NotNull String content) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(content, "content");
        Log.d(TAG, "quey cursor saveJsonAndGetUriString start      " + System.currentTimeMillis());
        ReentrantReadWriteLock reentrantReadWriteLock = rwLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            try {
                FilesKt__FileReadWriteKt.writeText$default(new File(context.getFilesDir(), "my_data.json"), content, null, 2, null);
                Log.d(DailyUsageEngineService.TAG, "file saved，URI is: content://com.stepos.alphame.dailyusage.provider/my_data.json");
                Log.d(TAG, "query cursor  saveJsonAndGetUriString  end       " + System.currentTimeMillis());
                reentrantReadWriteLock.writeLock().unlock();
                return "content://com.stepos.alphame.dailyusage.provider/my_data.json";
            } catch (Exception e4) {
                e4.printStackTrace();
                rwLock.writeLock().unlock();
                return "";
            }
        } catch (Throwable th) {
            rwLock.writeLock().unlock();
            throw th;
        }
    }

    @Override // android.content.ContentProvider
    public int update(@NotNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public ParcelFileDescriptor openFile(@NotNull Uri uri, @NotNull String mode, @Nullable CancellationSignal signal) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return getFileDescriptor(uri);
    }
}
