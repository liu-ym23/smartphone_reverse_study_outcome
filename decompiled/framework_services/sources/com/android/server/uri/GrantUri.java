package com.android.server.uri;

import android.content.ContentProvider;
import android.net.Uri;
import android.util.proto.ProtoOutputStream;
import com.android.server.wm.ActivityTaskManagerInternal;

/* JADX INFO: loaded from: classes3.dex */
public class GrantUri {
    public final boolean prefix;
    public final int sourceUserId;
    public final Uri uri;

    public GrantUri(int sourceUserId, Uri uri, int modeFlags) {
        this.sourceUserId = sourceUserId;
        this.uri = uri;
        if ((modeFlags & 128) == 0) goto L5;
        boolean r0 = true;
    L6:
        this.prefix = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public int hashCode() {
        int hashCode = (1 * 31) + this.sourceUserId;
        int hashCode2 = ((hashCode * 31) + this.uri.hashCode()) * 31;
        if (this.prefix == false) goto L5;
        int r2 = 1231;
    L7:
        return hashCode2 + r2;
    L5:
        r2 = 1237;
        goto L7
    }

    public boolean equals(Object o) {
        if ((o instanceof GrantUri) == false) goto L12;
        GrantUri other = (GrantUri) o;
        if (this.uri.equals(other.uri) == true) goto L7;
        return false;
    L7:
        if (this.sourceUserId == other.sourceUserId) goto L9;
        return false;
    L9:
        if (this.prefix != other.prefix) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public String toString() {
        String result = this.uri.toString() + " [user " + this.sourceUserId + "]";
        if (this.prefix == true) goto L5;
        return result;
    L5:
        return result + " [prefix]";
    }

    public String toSafeString() {
        String result = this.uri.toSafeString() + " [user " + this.sourceUserId + "]";
        if (this.prefix == true) goto L5;
        return result;
    L5:
        return result + " [prefix]";
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1138166333442L, this.uri.toString());
        proto.write(1120986464257L, this.sourceUserId);
        proto.end(token);
    }

    public static GrantUri resolve(int defaultSourceUserHandle, Uri uri, int modeFlags) {
        if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(uri.getScheme()) == false) goto L7;
        return new GrantUri(ContentProvider.getUserIdFromUri(uri, defaultSourceUserHandle), ContentProvider.getUriWithoutUserId(uri), modeFlags);
    L7:
        return new GrantUri(defaultSourceUserHandle, uri, modeFlags);
    }
}
