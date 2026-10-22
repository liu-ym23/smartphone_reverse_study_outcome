package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NotificationChannelGroupCompat {
    private boolean mBlocked;
    private List<NotificationChannelCompat> mChannels;
    String mDescription;
    final String mId;
    CharSequence mName;

    static class Api26Impl {
        private Api26Impl() {
        }

        static NotificationChannelGroup createNotificationChannelGroup(String r1, CharSequence r2) {
            return new NotificationChannelGroup(r1, r2);
        }

        static String getId(NotificationChannelGroup r0) {
            return r0.getId();
        }

        static CharSequence getName(NotificationChannelGroup r0) {
            return r0.getName();
        }

        static List<NotificationChannel> getChannels(NotificationChannelGroup r0) {
            return r0.getChannels();
        }

        static String getGroup(NotificationChannel r0) {
            return r0.getGroup();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static boolean isBlocked(NotificationChannelGroup r0) {
            return r0.isBlocked();
        }

        static String getDescription(NotificationChannelGroup r0) {
            return r0.getDescription();
        }

        static void setDescription(NotificationChannelGroup r0, String r1) {
            r0.setDescription(r1);
        }
    }

    public static class Builder {
        final NotificationChannelGroupCompat mGroup;

        public Builder(String r2) {
            this.mGroup = new NotificationChannelGroupCompat(r2);
        }

        public Builder setName(CharSequence r2) {
            this.mGroup.mName = r2;
            return this;
        }

        public Builder setDescription(String r2) {
            this.mGroup.mDescription = r2;
            return this;
        }

        public NotificationChannelGroupCompat build() {
            return this.mGroup;
        }
    }

    NotificationChannelGroupCompat(String r2) {
        this.mChannels = Collections.emptyList();
        this.mId = (String) Preconditions.checkNotNull(r2);
    }

    NotificationChannelGroupCompat(NotificationChannelGroup r2) {
        this(r2, Collections.emptyList());
    }

    NotificationChannelGroupCompat(NotificationChannelGroup r1, List<NotificationChannel> r2) {
        this(Api26Impl.getId(r1));
        this.mName = Api26Impl.getName(r1);
        this.mDescription = Api28Impl.getDescription(r1);
        this.mBlocked = Api28Impl.isBlocked(r1);
        this.mChannels = getChannelsCompat(Api26Impl.getChannels(r1));
    }

    private List<NotificationChannelCompat> getChannelsCompat(List<NotificationChannel> r5) {
        ArrayList r0 = new ArrayList();
        Iterator<NotificationChannel> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        NotificationChannel r1 = r6.next();
        if (this.mId.equals(Api26Impl.getGroup(r1)) == false) goto L4;
        r0.add(new NotificationChannelCompat(r1));
        goto L4
    L8:
        return r0;
    }

    NotificationChannelGroup getNotificationChannelGroup() {
        NotificationChannelGroup r0 = Api26Impl.createNotificationChannelGroup(this.mId, this.mName);
        Api28Impl.setDescription(r0, this.mDescription);
        return r0;
    }

    public Builder toBuilder() {
        return new Builder(this.mId).setName(this.mName).setDescription(this.mDescription);
    }

    public String getId() {
        return this.mId;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public boolean isBlocked() {
        return this.mBlocked;
    }

    public List<NotificationChannelCompat> getChannels() {
        return this.mChannels;
    }
}
