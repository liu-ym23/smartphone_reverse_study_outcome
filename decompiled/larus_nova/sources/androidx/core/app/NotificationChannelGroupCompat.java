package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public class NotificationChannelGroupCompat {
    private boolean mBlocked;
    private List<NotificationChannelCompat> mChannels;
    String mDescription;
    final String mId;
    CharSequence mName;

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static List<NotificationChannel> getChannels(NotificationChannelGroup r100) {
            return r100.getChannels();
        }

        public static String getGroup(NotificationChannel r100) {
            return r100.getGroup();
        }

        public static String getId(NotificationChannelGroup r100) {
            return r100.getId();
        }

        public static CharSequence getName(NotificationChannelGroup r100) {
            return r100.getName();
        }

        public static NotificationChannelGroup createNotificationChannelGroup(String r100, CharSequence r101) {
            return new NotificationChannelGroup(r100, r101);
        }
    }

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static String getDescription(NotificationChannelGroup r100) {
            return r100.getDescription();
        }

        public static boolean isBlocked(NotificationChannelGroup r100) {
            return r100.isBlocked();
        }

        public static void setDescription(NotificationChannelGroup r100, String r101) {
            r100.setDescription(r101);
        }
    }

    public static class Builder {
        final NotificationChannelGroupCompat mGroup;

        public NotificationChannelGroupCompat build() {
            return this.mGroup;
        }

        public Builder(String r100) {
            this.mGroup = new NotificationChannelGroupCompat(r100);
        }

        public Builder setDescription(String r100) {
            this.mGroup.mDescription = r100;
            return this;
        }

        public Builder setName(CharSequence r100) {
            this.mGroup.mName = r100;
            return this;
        }
    }

    public NotificationChannelGroup getNotificationChannelGroup() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 26) goto L6;
        return null;
    L6:
        NotificationChannelGroup r101 = Api26Impl.createNotificationChannelGroup(this.mId, this.mName);
        if (r100 < 28) goto L9;
        Api28Impl.setDescription(r101, this.mDescription);
    L9:
        return r101;
    }

    public Builder toBuilder() {
        return new Builder(this.mId).setName(this.mName).setDescription(this.mDescription);
    }

    public List<NotificationChannelCompat> getChannels() {
        return this.mChannels;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getId() {
        return this.mId;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public boolean isBlocked() {
        return this.mBlocked;
    }

    public NotificationChannelGroupCompat(String r100) {
        this.mChannels = Collections.emptyList();
        this.mId = (String) Preconditions.checkNotNull(r100);
    }

    private List<NotificationChannelCompat> getChannelsCompat(List<NotificationChannel> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<NotificationChannel> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        NotificationChannel r103 = r102.next();
        if (this.mId.equals(Api26Impl.getGroup(r103)) == false) goto L4;
        r101.add(new NotificationChannelCompat(r103));
        goto L4
    L8:
        return r101;
    }

    public NotificationChannelGroupCompat(NotificationChannelGroup r100) {
        this(r100, Collections.emptyList());
    }

    public NotificationChannelGroupCompat(NotificationChannelGroup r100, List<NotificationChannel> r101) {
        this(Api26Impl.getId(r100));
        this.mName = Api26Impl.getName(r100);
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 28) goto L5;
        this.mDescription = Api28Impl.getDescription(r100);
    L5:
        if (r102 < 28) goto L7;
        this.mBlocked = Api28Impl.isBlocked(r100);
        this.mChannels = getChannelsCompat(Api26Impl.getChannels(r100));
        return;
    L7:
        this.mChannels = getChannelsCompat(r101);
    }
}
