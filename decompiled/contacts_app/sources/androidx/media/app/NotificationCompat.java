package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.media.R;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCompat {

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r1) {
            return null;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r1) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor r1) {
            return null;
        }

        public DecoratedMediaCustomViewStyle() {
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r2) {
            r2.getBuilder().setStyle(fillInMediaStyle(new Notification.DecoratedMediaCustomViewStyle()));
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int getContentViewLayoutResource() {
            if (this.mBuilder.getContentView() == null) goto L6;
            return R.layout.notification_template_media_custom;
        L6:
            return super.getContentViewLayoutResource();
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int getBigContentViewLayoutResource(int r1) {
            if (r1 > 3) goto L6;
            return R.layout.notification_template_big_media_narrow_custom;
        L6:
            return R.layout.notification_template_big_media_custom;
        }

        private void setBackgroundColor(RemoteViews r3) {
            if (this.mBuilder.getColor() == 0) goto L5;
            int r2 = this.mBuilder.getColor();
        L6:
            r3.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", r2);
            return;
        L5:
            r2 = this.mBuilder.mContext.getResources().getColor(R.color.notification_material_background_media_default_color);
            goto L6
        }
    }

    public static class MediaStyle extends androidx.core.app.NotificationCompat.Style {
        private static final int MAX_MEDIA_BUTTONS = 5;
        private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        int[] mActionsToShowInCompact;
        PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        MediaSessionCompat.Token mToken;

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor r1) {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor r1) {
            return null;
        }

        public MediaStyle setShowCancelButton(boolean r1) {
            return this;
        }

        public static MediaSessionCompat.Token getMediaSession(Notification r1) {
            Bundle r2 = androidx.core.app.NotificationCompat.getExtras(r1);
            if (r2 == null) goto L8;
            Parcelable r3 = r2.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (r3 != null) goto L7;
            return null;
        L7:
            return MediaSessionCompat.Token.fromToken(r3);
        L8:
            return null;
        }

        public MediaStyle() {
            this.mActionsToShowInCompact = null;
        }

        public MediaStyle(androidx.core.app.NotificationCompat.Builder r2) {
            this.mActionsToShowInCompact = null;
            setBuilder(r2);
        }

        public MediaStyle setShowActionsInCompactView(int... r1) {
            this.mActionsToShowInCompact = r1;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token r1) {
            this.mToken = r1;
            return this;
        }

        public MediaStyle setCancelButtonIntent(PendingIntent r1) {
            this.mCancelButtonIntent = r1;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void apply(NotificationBuilderWithBuilderAccessor r2) {
            r2.getBuilder().setStyle(fillInMediaStyle(new Notification.MediaStyle()));
        }

        Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle r2) {
            int[] r0 = this.mActionsToShowInCompact;
            if (r0 == null) goto L5;
            r2.setShowActionsInCompactView(r0);
        L5:
            MediaSessionCompat.Token r1 = this.mToken;
            if (r1 == null) goto L8;
            r2.setMediaSession((MediaSession.Token) r1.getToken());
        L8:
            return r2;
        }

        RemoteViews generateContentView() {
            RemoteViews r0 = applyStandardTemplate(false, getContentViewLayoutResource(), true);
            int r3 = this.mBuilder.mActions.size();
            int[] r4 = this.mActionsToShowInCompact;
            if (r4 != null) goto L5;
            int r5 = 0;
        L6:
            r0.removeAllViews(R.id.media_actions);
            if (r5 <= 0) goto L15;
            int r6 = 0;
        L9:
            if (r6 >= r5) goto L15;
            if (r6 >= r3) goto L13;
            r0.addView(R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(this.mActionsToShowInCompact[r6])));
            r6 = r6 + 1;
            goto L9
        L13:
            throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(r6), Integer.valueOf(r3 - 1)}));
        L15:
            if (this.mShowCancelButton == false) goto L17;
            r0.setViewVisibility(R.id.end_padder, 8);
            r0.setViewVisibility(R.id.cancel_action, 0);
            r0.setOnClickPendingIntent(R.id.cancel_action, this.mCancelButtonIntent);
            r0.setInt(R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
        L18:
            return r0;
        L17:
            r0.setViewVisibility(R.id.end_padder, 0);
            r0.setViewVisibility(R.id.cancel_action, 8);
            goto L18
        L5:
            r5 = Math.min(r4.length, 3);
            goto L6
        }

        private RemoteViews generateMediaActionButton(androidx.core.app.NotificationCompat.Action r4) {
            if (r4.getActionIntent() != null) goto L5;
            boolean r0 = true;
        L6:
            RemoteViews r1 = new RemoteViews(this.mBuilder.mContext.getPackageName(), R.layout.notification_media_action);
            r1.setImageViewResource(R.id.action0, r4.getIcon());
            if (r0 == true) goto L9;
            r1.setOnClickPendingIntent(R.id.action0, r4.getActionIntent());
        L9:
            r1.setContentDescription(R.id.action0, r4.getTitle());
            return r1;
        L5:
            r0 = false;
            goto L6
        }

        int getContentViewLayoutResource() {
            return R.layout.notification_template_media;
        }

        RemoteViews generateBigContentView() {
            int r0 = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews r1 = applyStandardTemplate(false, getBigContentViewLayoutResource(r0), false);
            r1.removeAllViews(R.id.media_actions);
            if (r0 <= 0) goto L8;
            int r3 = 0;
        L5:
            if (r3 >= r0) goto L8;
            r1.addView(R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(r3)));
            r3 = r3 + 1;
        L8:
            if (this.mShowCancelButton == false) goto L10;
            r1.setViewVisibility(R.id.cancel_action, 0);
            r1.setInt(R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
            r1.setOnClickPendingIntent(R.id.cancel_action, this.mCancelButtonIntent);
        L11:
            return r1;
        L10:
            r1.setViewVisibility(R.id.cancel_action, 8);
            goto L11
        }

        int getBigContentViewLayoutResource(int r1) {
            if (r1 > 3) goto L6;
            return R.layout.notification_template_big_media_narrow;
        L6:
            return R.layout.notification_template_big_media;
        }
    }

    private NotificationCompat() {
    }
}
