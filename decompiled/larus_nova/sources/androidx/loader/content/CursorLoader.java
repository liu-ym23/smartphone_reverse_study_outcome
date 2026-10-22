package androidx.loader.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.ContentResolverCompat;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes17.dex */
public class CursorLoader extends AsyncTaskLoader<Cursor> {
    CancellationSignal mCancellationSignal;
    Cursor mCursor;
    final Loader<Cursor>.ForceLoadContentObserver mObserver;
    String[] mProjection;
    String mSelection;
    String[] mSelectionArgs;
    String mSortOrder;
    Uri mUri;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.loader.content.AsyncTaskLoader
    public Cursor loadInBackground() {
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L4:
        if (isLoadInBackgroundCanceled() == true) goto L31;
        this.mCancellationSignal = new CancellationSignal();     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        Cursor r100 = ContentResolverCompat.query(getContext().getContentResolver(), this.mUri, this.mProjection, this.mSelection, this.mSelectionArgs, this.mSortOrder, this.mCancellationSignal);     // Catch: Throwable -> L22
        if (r100 != null) goto L38;
    L15:
        monitor-enter(this);
        this.mCancellationSignal = null;     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return r100;
    L19:
        th = move-exception;
        throw th;
    L38:
        r100.getCount();     // Catch: RuntimeException -> L12 Throwable -> L22
        r100.registerContentObserver(this.mObserver);     // Catch: RuntimeException -> L12 Throwable -> L22
    L12:
        e = move-exception;
        r100.close();     // Catch: Throwable -> L22
        throw e;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        monitor-enter(this);
        this.mCancellationSignal = null;     // Catch: Throwable -> L27
        throw th;
    L27:
        th = move-exception;
        throw th;
    L31:
        throw new OperationCanceledException();     // Catch: Throwable -> L32
    }

    @Override // androidx.loader.content.Loader
    public void onStartLoading() {
        Cursor r100 = this.mCursor;
        if (r100 == null) goto L6;
        deliverResult(r100);
    L6:
        if (takeContentChanged() == false) goto L8;
    L9:
        forceLoad();
        return;
    L8:
        if (this.mCursor == null) goto L9;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        monitor-enter(this);
        CancellationSignal r100 = this.mCancellationSignal;     // Catch: Throwable -> L9
        if (r100 == null) goto L7;
        r100.cancel();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // androidx.loader.content.Loader
    public void onReset() {
        super.onReset();
        onStopLoading();
        Cursor r100 = this.mCursor;
        if (r100 != null) goto L5;
    L7:
        this.mCursor = null;
        return;
    L5:
        if (r100.isClosed() == true) goto L7;
        this.mCursor.close();
        goto L7
    }

    public String[] getProjection() {
        return this.mProjection;
    }

    public String getSelection() {
        return this.mSelection;
    }

    public String[] getSelectionArgs() {
        return this.mSelectionArgs;
    }

    public String getSortOrder() {
        return this.mSortOrder;
    }

    public Uri getUri() {
        return this.mUri;
    }

    @Override // androidx.loader.content.Loader
    public void onStopLoading() {
        cancelLoad();
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ Cursor loadInBackground() {
        return loadInBackground();
    }

    public CursorLoader(Context r100) {
        super(r100);
        this.mObserver = new Loader.ForceLoadContentObserver(this);
    }

    public void deliverResult(Cursor r100) {
        if (isReset() == false) goto L7;
        if (r100 == null) goto L16;
        r100.close();
        return;
    L16:
        return;
    L7:
        Cursor r101 = this.mCursor;
        this.mCursor = r100;
        if (isStarted() == false) goto L10;
        super.deliverResult(r100);
    L10:
        if (r101 == null) goto L17;
        if (r101 != r100) goto L13;
        return;
    L13:
        if (r101.isClosed() == true) goto L19;
        r101.close();
        return;
    L19:
        return;
    }

    /* JADX INFO: renamed from: onCanceled, reason: avoid collision after fix types in other method */
    public void onCanceled2(Cursor r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isClosed() == true) goto L8;
        r100.close();
        return;
    }

    public void setProjection(String[] r100) {
        this.mProjection = r100;
    }

    public void setSelection(String r100) {
        this.mSelection = r100;
    }

    public void setSelectionArgs(String[] r100) {
        this.mSelectionArgs = r100;
    }

    public void setSortOrder(String r100) {
        this.mSortOrder = r100;
    }

    public void setUri(Uri r100) {
        this.mUri = r100;
    }

    @Override // androidx.loader.content.Loader
    public /* bridge */ /* synthetic */ void deliverResult(Object r100) {
        deliverResult((Cursor) r100);
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public /* bridge */ /* synthetic */ void onCanceled(Cursor r100) {
        onCanceled2(r100);
    }

    @Override // androidx.loader.content.AsyncTaskLoader, androidx.loader.content.Loader
    public void dump(String r100, FileDescriptor r101, PrintWriter r102, String[] r103) {
        super.dump(r100, r101, r102, r103);
        r102.print(r100);
        r102.print("mUri=");
        r102.println(this.mUri);
        r102.print(r100);
        r102.print("mProjection=");
        r102.println(Arrays.toString(this.mProjection));
        r102.print(r100);
        r102.print("mSelection=");
        r102.println(this.mSelection);
        r102.print(r100);
        r102.print("mSelectionArgs=");
        r102.println(Arrays.toString(this.mSelectionArgs));
        r102.print(r100);
        r102.print("mSortOrder=");
        r102.println(this.mSortOrder);
        r102.print(r100);
        r102.print("mCursor=");
        r102.println(this.mCursor);
        r102.print(r100);
        r102.print("mContentChanged=");
        r102.println(this.mContentChanged);
    }

    public CursorLoader(Context r100, Uri r101, String[] r102, String r103, String[] r104, String r105) {
        super(r100);
        this.mObserver = new Loader.ForceLoadContentObserver(this);
        this.mUri = r101;
        this.mProjection = r102;
        this.mSelection = r103;
        this.mSelectionArgs = r104;
        this.mSortOrder = r105;
    }
}
