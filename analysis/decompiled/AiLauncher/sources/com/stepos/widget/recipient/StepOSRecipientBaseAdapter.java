package com.stepos.widget.recipient;

import La.H;
import Z8.r;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.widget.Filter;
import android.widget.Filterable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.recipient.StepOSCompositeCursorAdapter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0015\b&\u0018\u0000 A2\u00020\u00012\u00020\u0002:\nBCDEFGHIJAB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH$¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0013\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH$¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0013\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u0013\u0010\u0016J#\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u0017H$¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001c\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH$¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010\u001c\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u001c\u0010\u001eJ!\u0010\"\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020 H$¢\u0006\u0004\b\"\u0010#J#\u0010$\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH$¢\u0006\u0004\b$\u0010%J\u001f\u0010(\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001fH'¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001fH&¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020 2\u0006\u0010,\u001a\u00020\u001fH&¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020 2\u0006\u0010,\u001a\u00020\u001fH\u0016¢\u0006\u0004\b/\u0010.J\u0017\u00100\u001a\u00020 2\u0006\u0010,\u001a\u00020\u001fH&¢\u0006\u0004\b0\u0010.J\u0017\u00102\u001a\u00020 2\u0006\u00101\u001a\u00020\u001fH&¢\u0006\u0004\b2\u0010.J\u000f\u00103\u001a\u00020\u0012H'¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0012H'¢\u0006\u0004\b5\u00104J\u000f\u00107\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\u0015\u0010:\u001a\u00020 2\u0006\u00109\u001a\u00020\u0005¢\u0006\u0004\b:\u0010;J\r\u0010<\u001a\u00020\u0005¢\u0006\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\f\n\u0004\b>\u0010?\u0012\u0004\b@\u00104¨\u0006K"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;", "Lcom/stepos/widget/recipient/StepOSCompositeCursorAdapter;", "Landroid/widget/Filterable;", "Landroid/content/Context;", "context", "", "inputtype", "<init>", "(Landroid/content/Context;I)V", "", "constraint", "", "onDefaultFiltering", "(Ljava/lang/CharSequence;)Ljava/lang/Object;", "Landroid/database/Cursor;", "groupCursor", "contactCursor", "snsCursor", "LY8/t;", "onDefaultLoadFinished", "(Ljava/lang/CharSequence;Landroid/database/Cursor;Landroid/database/Cursor;Landroid/database/Cursor;)V", UxipConstants.f30680s, "(Ljava/lang/CharSequence;Ljava/lang/Object;)V", "", "directoryId", "onDirectoryFiltering", "(Ljava/lang/CharSequence;J)Ljava/lang/Object;", "cursor", "onDirectoryLoadFinished", "(Ljava/lang/CharSequence;JLandroid/database/Cursor;)V", "(Ljava/lang/CharSequence;JLjava/lang/Object;)V", "", "", "queryByNetwork", "onSnsFiltering", "(Ljava/lang/String;Z)Landroid/database/Cursor;", "onSnsLoadFinished", "(Ljava/lang/CharSequence;Landroid/database/Cursor;)V", "phoneOrEmail", "name", "goContactDetail", "(Ljava/lang/String;Ljava/lang/String;)V", "queryDisplayName", "(Ljava/lang/String;)Ljava/lang/String;", Const.JSON_KEY_NUMBER, "isSns", "(Ljava/lang/String;)Z", "isValid", "isPhoneNumber", Const.JSON_KEY_ADDRESS, "isEmailAddress", "registerContentObserver", "()V", "unregisterContentObserver", "Landroid/widget/Filter;", "getFilter", "()Landroid/widget/Filter;", "position", "isGroupData", "(I)Z", "getInputType", "()I", "inputType", "I", "getInputType$annotations", "Companion", "InputType", "FlagPartition", "GroupPartition", "DirectoryPartition", "SnsPartition", "DefaultPartitionFilter", "DirectoryPartitionFilter", "SnsPartitionFilter", "Recipient", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class StepOSRecipientBaseAdapter extends StepOSCompositeCursorAdapter implements Filterable {
    public static final int DATA_INDEX = 1;
    public static final int ID_INDEX = 3;
    public static final int INPUT_TYPE_EMAIL = 2;
    public static final int INPUT_TYPE_PHONE = 1;
    public static final int INPUT_TYPE_SNS = 4;
    public static final long INVALID_ID = 0;
    public static final int NAME_INDEX = 0;
    public static final int ORGANIZATION_INDEX = 2;
    public static final String TAG = "RecipientBaseAdapter";
    private final int inputType;
    public static final String ORGANIZATION_NOTE = "organization_note";
    public static final String[] PROJECTION = {StepOSRecipientEmailHistory.DISPLAY_NAME, StepOSEmailRecipientAdapter.DATA1, ORGANIZATION_NOTE, StepOSRecipientEmailHistory._ID};

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$DefaultPartitionFilter;", "Landroid/widget/Filter;", "<init>", "(Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;)V", "", "constraint", "Landroid/widget/Filter$FilterResults;", "performFiltering", "(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;", "results", "LY8/t;", "publishResults", "(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;)V", "", "resultValue", "convertResultToString", "(Ljava/lang/Object;)Ljava/lang/CharSequence;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class DefaultPartitionFilter extends Filter {
        public DefaultPartitionFilter() {
        }

        @Override // android.widget.Filter
        public CharSequence convertResultToString(Object resultValue) {
            return "";
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence constraint) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.values = StepOSRecipientBaseAdapter.this.onDefaultFiltering(constraint);
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence constraint, Filter.FilterResults results) {
            kotlin.jvm.internal.p.i(results, "results");
            Object obj = results.values;
            if (obj != null) {
                if (obj instanceof Object[]) {
                    StepOSRecipientBaseAdapter stepOSRecipientBaseAdapter = StepOSRecipientBaseAdapter.this;
                    Object[] objArr = (Object[]) obj;
                    Object objJ0 = r.j0(objArr, 0);
                    Cursor cursor = objJ0 instanceof Cursor ? (Cursor) objJ0 : null;
                    Object objJ02 = r.j0(objArr, 1);
                    Cursor cursor2 = objJ02 instanceof Cursor ? (Cursor) objJ02 : null;
                    Object objJ03 = r.j0(objArr, 2);
                    stepOSRecipientBaseAdapter.onDefaultLoadFinished(constraint, cursor, cursor2, objJ03 instanceof Cursor ? (Cursor) objJ03 : null);
                } else {
                    StepOSRecipientBaseAdapter.this.onDefaultLoadFinished(constraint, obj);
                }
            }
            results.count = StepOSRecipientBaseAdapter.this.getCount();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0096\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\b\u0018\u00010 R\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$DirectoryPartition;", "Lcom/stepos/widget/recipient/StepOSCompositeCursorAdapter$Partition;", "<init>", "(Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;)V", "directoryId", "", "getDirectoryId", "()J", "setDirectoryId", "(J)V", "directoryType", "", "getDirectoryType", "()Ljava/lang/String;", "setDirectoryType", "(Ljava/lang/String;)V", "displayName", "getDisplayName", "setDisplayName", "accountName", "getAccountName", "setAccountName", "accountType", "getAccountType", "setAccountType", "constraint", "", "getConstraint", "()Ljava/lang/CharSequence;", "setConstraint", "(Ljava/lang/CharSequence;)V", "filter", "Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$DirectoryPartitionFilter;", "Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;", "getFilter", "()Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$DirectoryPartitionFilter;", "setFilter", "(Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$DirectoryPartitionFilter;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public class DirectoryPartition extends StepOSCompositeCursorAdapter.Partition {
        private String accountName;
        private String accountType;
        private CharSequence constraint;
        private long directoryId;
        private String directoryType;
        private String displayName;
        private DirectoryPartitionFilter filter;

        public DirectoryPartition() {
            super(false, false);
        }

        public final String getAccountName() {
            return this.accountName;
        }

        public final String getAccountType() {
            return this.accountType;
        }

        public final CharSequence getConstraint() {
            return this.constraint;
        }

        public final long getDirectoryId() {
            return this.directoryId;
        }

        public final String getDirectoryType() {
            return this.directoryType;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final DirectoryPartitionFilter getFilter() {
            return this.filter;
        }

        public final void setAccountName(String str) {
            this.accountName = str;
        }

        public final void setAccountType(String str) {
            this.accountType = str;
        }

        public final void setConstraint(CharSequence charSequence) {
            this.constraint = charSequence;
        }

        public final void setDirectoryId(long j10) {
            this.directoryId = j10;
        }

        public final void setDirectoryType(String str) {
            this.directoryType = str;
        }

        public final void setDisplayName(String str) {
            this.displayName = str;
        }

        public final void setFilter(DirectoryPartitionFilter directoryPartitionFilter) {
            this.filter = directoryPartitionFilter;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$DirectoryPartitionFilter;", "Landroid/widget/Filter;", "", "partitionIndex", "", "directoryId", "<init>", "(Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;IJ)V", "", "constraint", "Landroid/widget/Filter$FilterResults;", "performFiltering", "(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;", "results", "LY8/t;", "publishResults", "(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;)V", "", "resultValue", "convertResultToString", "(Ljava/lang/Object;)Ljava/lang/CharSequence;", "I", "J", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class DirectoryPartitionFilter extends Filter {
        private final long directoryId;
        private final int partitionIndex;

        public DirectoryPartitionFilter(int i10, long j10) {
            this.partitionIndex = i10;
            this.directoryId = j10;
        }

        @Override // android.widget.Filter
        public CharSequence convertResultToString(Object resultValue) {
            return "";
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence constraint) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.values = StepOSRecipientBaseAdapter.this.onDirectoryFiltering(constraint, this.directoryId);
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence constraint, Filter.FilterResults results) {
            kotlin.jvm.internal.p.i(results, "results");
            Object obj = results.values;
            if (obj != null) {
                if (obj instanceof Cursor) {
                    StepOSRecipientBaseAdapter.this.onDirectoryLoadFinished(constraint, this.directoryId, (Cursor) obj);
                } else {
                    StepOSRecipientBaseAdapter.this.onDirectoryLoadFinished(constraint, this.directoryId, obj);
                }
            }
            results.count = StepOSRecipientBaseAdapter.this.getCount();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0096\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$FlagPartition;", "Lcom/stepos/widget/recipient/StepOSCompositeCursorAdapter$Partition;", "<init>", "(Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public class FlagPartition extends StepOSCompositeCursorAdapter.Partition {
        public FlagPartition() {
            super(true, true);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0096\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$GroupPartition;", "Lcom/stepos/widget/recipient/StepOSCompositeCursorAdapter$Partition;", "<init>", "(Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public class GroupPartition extends StepOSCompositeCursorAdapter.Partition {
        public GroupPartition() {
            super(false, false);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$InputType;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface InputType {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$Recipient;", "", "<init>", "()V", "mAddress", "", "getMAddress", "()Ljava/lang/String;", "setMAddress", "(Ljava/lang/String;)V", "mDisplayName", "getMDisplayName", "setMDisplayName", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Recipient {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private String mAddress = "";
        private String mDisplayName = "";

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\r\u001a\u00020\t2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u0007J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0006H\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$Recipient$Companion;", "", "<init>", "()V", "dataToRecipientList", "Ljava/util/ArrayList;", "Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$Recipient;", "Lkotlin/collections/ArrayList;", "data", "", "dataToRecipient", "dataIn", "Ljava/io/DataInputStream;", "recipientListToData", "recipientList", "recipientToData", "recipient", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            private final Recipient dataToRecipient(DataInputStream dataIn) throws IOException {
                Recipient recipient = new Recipient();
                recipient.setMAddress(dataIn.readUTF());
                recipient.setMDisplayName(dataIn.readUTF());
                return recipient;
            }

            public final ArrayList<Recipient> dataToRecipientList(byte[] data) throws IOException {
                ArrayList<Recipient> arrayList = new ArrayList<>();
                if (data != null) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
                    DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                    while (dataInputStream.available() > 0) {
                        try {
                            try {
                                try {
                                    arrayList.add(dataToRecipient(dataInputStream));
                                } catch (Throwable th) {
                                    try {
                                        byteArrayInputStream.close();
                                        dataInputStream.close();
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                    }
                                    throw th;
                                }
                            } catch (IOException e11) {
                                e11.printStackTrace();
                                byteArrayInputStream.close();
                                dataInputStream.close();
                            }
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    byteArrayInputStream.close();
                    dataInputStream.close();
                }
                return arrayList;
            }

            public final byte[] recipientListToData(ArrayList<Recipient> recipientList) throws IOException {
                kotlin.jvm.internal.p.i(recipientList, "recipientList");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    try {
                        try {
                            Iterator<Recipient> it = recipientList.iterator();
                            kotlin.jvm.internal.p.h(it, "iterator(...)");
                            while (it.hasNext()) {
                                Recipient next = it.next();
                                kotlin.jvm.internal.p.h(next, "next(...)");
                                Recipient recipient = next;
                                dataOutputStream.writeUTF(recipient.getMAddress());
                                dataOutputStream.writeUTF(recipient.getMDisplayName());
                            }
                            byteArrayOutputStream.close();
                            dataOutputStream.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                            byteArrayOutputStream.close();
                            dataOutputStream.close();
                        }
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    kotlin.jvm.internal.p.h(byteArray, "toByteArray(...)");
                    return byteArray;
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                        dataOutputStream.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                    throw th;
                }
            }

            public final byte[] recipientToData(Recipient recipient) {
                kotlin.jvm.internal.p.i(recipient, "recipient");
                ArrayList<Recipient> arrayList = new ArrayList<>();
                arrayList.add(recipient);
                return recipientListToData(arrayList);
            }

            private Companion() {
            }
        }

        public static final ArrayList<Recipient> dataToRecipientList(byte[] bArr) {
            return INSTANCE.dataToRecipientList(bArr);
        }

        public static final byte[] recipientListToData(ArrayList<Recipient> arrayList) {
            return INSTANCE.recipientListToData(arrayList);
        }

        public static final byte[] recipientToData(Recipient recipient) {
            return INSTANCE.recipientToData(recipient);
        }

        public final String getMAddress() {
            return this.mAddress;
        }

        public final String getMDisplayName() {
            return this.mDisplayName;
        }

        public final void setMAddress(String str) {
            kotlin.jvm.internal.p.i(str, "<set-?>");
            this.mAddress = str;
        }

        public final void setMDisplayName(String str) {
            kotlin.jvm.internal.p.i(str, "<set-?>");
            this.mDisplayName = str;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0096\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0018\u00010\u000bR\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$SnsPartition;", "Lcom/stepos/widget/recipient/StepOSCompositeCursorAdapter$Partition;", "<init>", "(Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;)V", "constraint", "", "getConstraint", "()Ljava/lang/CharSequence;", "setConstraint", "(Ljava/lang/CharSequence;)V", "filter", "Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$SnsPartitionFilter;", "Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;", "getFilter", "()Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$SnsPartitionFilter;", "setFilter", "(Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$SnsPartitionFilter;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public class SnsPartition extends StepOSCompositeCursorAdapter.Partition {
        private CharSequence constraint;
        private SnsPartitionFilter filter;

        public SnsPartition() {
            super(false, false);
        }

        public final CharSequence getConstraint() {
            return this.constraint;
        }

        public final SnsPartitionFilter getFilter() {
            return this.filter;
        }

        public final void setConstraint(CharSequence charSequence) {
            this.constraint = charSequence;
        }

        public final void setFilter(SnsPartitionFilter snsPartitionFilter) {
            this.filter = snsPartitionFilter;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter$SnsPartitionFilter;", "Landroid/widget/Filter;", "<init>", "(Lcom/stepos/widget/recipient/StepOSRecipientBaseAdapter;)V", "", "constraint", "Landroid/widget/Filter$FilterResults;", "performFiltering", "(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;", "results", "LY8/t;", "publishResults", "(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;)V", "", "resultValue", "convertResultToString", "(Ljava/lang/Object;)Ljava/lang/CharSequence;", "", "mQueryByNetwork", "Z", "getMQueryByNetwork", "()Z", "setMQueryByNetwork", "(Z)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class SnsPartitionFilter extends Filter {
        private boolean mQueryByNetwork;

        public SnsPartitionFilter() {
        }

        @Override // android.widget.Filter
        public CharSequence convertResultToString(Object resultValue) {
            return "";
        }

        public final boolean getMQueryByNetwork() {
            return this.mQueryByNetwork;
        }

        @Override // android.widget.Filter
        public Filter.FilterResults performFiltering(CharSequence constraint) {
            String string;
            String string2 = (constraint == null || (string = constraint.toString()) == null) ? null : H.D1(string).toString();
            if (string2 == null) {
                string2 = "";
            }
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (!TextUtils.isEmpty(string2)) {
                filterResults.values = StepOSRecipientBaseAdapter.this.onSnsFiltering(string2, this.mQueryByNetwork);
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        public void publishResults(CharSequence constraint, Filter.FilterResults results) {
            kotlin.jvm.internal.p.i(results, "results");
            Object obj = results.values;
            StepOSRecipientBaseAdapter.this.onSnsLoadFinished(constraint, obj instanceof Cursor ? (Cursor) obj : null);
            results.count = StepOSRecipientBaseAdapter.this.getCount();
        }

        public final void setMQueryByNetwork(boolean z10) {
            this.mQueryByNetwork = z10;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSRecipientBaseAdapter(Context context, int i10) {
        super(context, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.inputType = i10;
    }

    private static /* synthetic */ void getInputType$annotations() {
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new DefaultPartitionFilter();
    }

    public final int getInputType() {
        return this.inputType;
    }

    public abstract void goContactDetail(String phoneOrEmail, String name);

    public abstract boolean isEmailAddress(String address);

    public final boolean isGroupData(int position) {
        int partitionForPosition = getPartitionForPosition(position);
        if (partitionForPosition < 0) {
            return false;
        }
        return getPartition(partitionForPosition) instanceof GroupPartition;
    }

    public abstract boolean isPhoneNumber(String number);

    public abstract boolean isSns(String number);

    public boolean isValid(String number) {
        kotlin.jvm.internal.p.i(number, "number");
        return true;
    }

    public abstract Object onDefaultFiltering(CharSequence constraint);

    public abstract void onDefaultLoadFinished(CharSequence constraint, Cursor groupCursor, Cursor contactCursor, Cursor snsCursor);

    public void onDefaultLoadFinished(CharSequence constraint, Object value) {
    }

    public abstract Object onDirectoryFiltering(CharSequence constraint, long directoryId);

    public abstract void onDirectoryLoadFinished(CharSequence constraint, long directoryId, Cursor cursor);

    public void onDirectoryLoadFinished(CharSequence constraint, long directoryId, Object value) {
    }

    public abstract Cursor onSnsFiltering(String constraint, boolean queryByNetwork);

    public abstract void onSnsLoadFinished(CharSequence constraint, Cursor cursor);

    public abstract String queryDisplayName(String phoneOrEmail);

    public abstract void registerContentObserver();

    public abstract void unregisterContentObserver();
}
