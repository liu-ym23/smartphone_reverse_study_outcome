package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes17.dex */
public class NotificationCompat {

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        @Override // androidx.media.app.NotificationCompat.MediaStyle
        public int getBigContentViewLayoutResource(int r100) {
            if (r100 > 3) goto L5;
            return R.layout.notification_template_big_media_narrow_custom;
        L5:
            return R.layout.notification_template_big_media_custom;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        public int getContentViewLayoutResource() {
            if (this.mBuilder.getContentView() == null) goto L6;
            return R.layout.notification_template_media_custom;
        L6:
            return super.getContentViewLayoutResource();
        }

        public DecoratedMediaCustomViewStyle() {
        }

        private void setBackgroundColor(RemoteViews r100) {
            if (this.mBuilder.getColor() == 0) goto L5;
            int r101 = this.mBuilder.getColor();
        L6:
            r100.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", r101);
            return;
        L5:
            r101 = this.mBuilder.mContext.getResources().getColor(R.color.notification_material_background_media_default_color);
            goto L6
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r100) {
            if (Build.VERSION.SDK_INT < 24) goto L5;
            r100.getBuilder().setStyle(fillInMediaStyle(new Notification.DecoratedMediaCustomViewStyle()));
            return;
        L5:
            super.apply(r100);
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r100) {
            if (Build.VERSION.SDK_INT < 24) goto L6;
            return null;
        L6:
            if (this.mBuilder.getBigContentView() == null) goto L8;
            RemoteViews r101 = this.mBuilder.getBigContentView();
        L9:
            if (r101 != null) goto L11;
            return null;
        L11:
            RemoteViews r102 = generateBigContentView();
            buildIntoRemoteViews(r102, r101);
            setBackgroundColor(r102);
            return r102;
        L8:
            r101 = this.mBuilder.getContentView();
            goto L9
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r100) {
            if (Build.VERSION.SDK_INT < 24) goto L5;
            return null;
        L5:
            boolean r101 = true;
            if (this.mBuilder.getContentView() == null) goto L8;
            boolean r102 = true;
        L9:
            if (r102 == false) goto L11;
        L14:
            if (r101 == false) goto L20;
            RemoteViews r103 = generateContentView();
            if (r102 == false) goto L18;
            buildIntoRemoteViews(r103, this.mBuilder.getContentView());
        L18:
            setBackgroundColor(r103);
            return r103;
        L20:
            return null;
        L11:
            if (this.mBuilder.getBigContentView() != null) goto L14;
            r101 = false;
            goto L14
        L8:
            r102 = false;
            goto L9
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r100) {
            if (Build.VERSION.SDK_INT < 24) goto L6;
            return null;
        L6:
            if (this.mBuilder.getHeadsUpContentView() == null) goto L8;
            RemoteViews r101 = this.mBuilder.getHeadsUpContentView();
        L9:
            if (r101 != null) goto L11;
            return null;
        L11:
            RemoteViews r102 = generateBigContentView();
            buildIntoRemoteViews(r102, r101);
            setBackgroundColor(r102);
            return r102;
        L8:
            r101 = this.mBuilder.getContentView();
            goto L9
        }
    }

    public static class MediaStyle extends androidx.core.app.NotificationCompat.Style {
        private static final int MAX_MEDIA_BUTTONS = 5;
        private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        int[] mActionsToShowInCompact;
        PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        MediaSessionCompat.Token mToken;

        public int getBigContentViewLayoutResource(int r100) {
            if (r100 > 3) goto L5;
            return R.layout.notification_template_big_media_narrow;
        L5:
            return R.layout.notification_template_big_media;
        }

        public int getContentViewLayoutResource() {
            return R.layout.notification_template_media;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r100) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r100) {
            return null;
        }

        public MediaStyle setShowCancelButton(boolean r100) {
            return this;
        }

        public RemoteViews generateBigContentView() {
            int r100 = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews r101 = applyStandardTemplate(false, getBigContentViewLayoutResource(r100), false);
            r101.removeAllViews(R.id.media_actions);
            if (r100 <= 0) goto L8;
            int r102 = 0;
        L5:
            if (r102 >= r100) goto L8;
            r101.addView(R.id.media_actions, generateMediaActionButton((androidx.core.app.NotificationCompat.Action) ListProtector.get(this.mBuilder.mActions, r102)));
            r102 = r102 + 1;
        L8:
            if (this.mShowCancelButton == false) goto L10;
            r101.setViewVisibility(R.id.cancel_action, 0);
            r101.setInt(R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
            r101.setOnClickPendingIntent(R.id.cancel_action, this.mCancelButtonIntent);
        L11:
            return r101;
        L10:
            r101.setViewVisibility(R.id.cancel_action, 8);
            goto L11
        }

        public MediaStyle() {
            this.mActionsToShowInCompact = null;
        }

        public RemoteViews generateContentView() {
            RemoteViews r100 = applyStandardTemplate(false, getContentViewLayoutResource(), true);
            int r101 = this.mBuilder.mActions.size();
            int[] r102 = this.mActionsToShowInCompact;
            if (r102 != null) goto L5;
            int r103 = 0;
        L6:
            r100.removeAllViews(R.id.media_actions);
            if (r103 <= 0) goto L15;
            int r104 = 0;
        L9:
            if (r104 >= r103) goto L15;
            if (r104 >= r101) goto L13;
            r100.addView(R.id.media_actions, generateMediaActionButton((androidx.core.app.NotificationCompat.Action) ListProtector.get(this.mBuilder.mActions, this.mActionsToShowInCompact[r104])));
            r104 = r104 + 1;
            goto L9
        L13:
            throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(r104), Integer.valueOf(r101 - 1)}));
        L15:
            if (this.mShowCancelButton == false) goto L17;
            r100.setViewVisibility(R.id.end_padder, 8);
            r100.setViewVisibility(R.id.cancel_action, 0);
            r100.setOnClickPendingIntent(R.id.cancel_action, this.mCancelButtonIntent);
            r100.setInt(R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
        L18:
            return r100;
        L17:
            r100.setViewVisibility(R.id.end_padder, 0);
            r100.setViewVisibility(R.id.cancel_action, 8);
            goto L18
        L5:
            r103 = Math.min(r102.length, 3);
            goto L6
        }

        public MediaStyle(androidx.core.app.NotificationCompat.Builder r100) {
            this.mActionsToShowInCompact = null;
            setBuilder(r100);
        }

        private RemoteViews generateMediaActionButton(androidx.core.app.NotificationCompat.Action r100) {
            if (r100.getActionIntent() != null) goto L5;
            boolean r101 = true;
        L6:
            RemoteViews r102 = new RemoteViews(this.mBuilder.mContext.getPackageName(), R.layout.notification_media_action);
            r102.setImageViewResource(R.id.action0, r100.getIcon());
            if (r101 == true) goto L9;
            r102.setOnClickPendingIntent(R.id.action0, r100.getActionIntent());
        L9:
            r102.setContentDescription(R.id.action0, r100.getTitle());
            return r102;
        L5:
            r101 = false;
            goto L6
        }

        public static MediaSessionCompat.Token getMediaSession(Notification r100) {
            Bundle r101 = androidx.core.app.NotificationCompat.getExtras(r100);
            if (r101 == null) goto L8;
            Parcelable r102 = r101.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (r102 != null) goto L7;
            return null;
        L7:
            return MediaSessionCompat.Token.fromToken(r102);
        L8:
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r100) {
            r100.getBuilder().setStyle(fillInMediaStyle(new Notification.MediaStyle()));
        }

        public Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle r100) {
            int[] r101 = this.mActionsToShowInCompact;
            if (r101 == null) goto L5;
            r100.setShowActionsInCompactView(r101);
        L5:
            MediaSessionCompat.Token r102 = this.mToken;
            if (r102 == null) goto L8;
            r100.setMediaSession((MediaSession.Token) r102.getToken());
        L8:
            return r100;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent r100) {
            this.mCancelButtonIntent = r100;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token r100) {
            this.mToken = r100;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... r100) {
            this.mActionsToShowInCompact = r100;
            return this;
        }
    }

    private NotificationCompat() {
    }
}
