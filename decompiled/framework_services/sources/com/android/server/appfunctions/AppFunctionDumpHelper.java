package com.android.server.appfunctions;

import android.app.appsearch.AppSearchManager;
import android.app.appsearch.GenericDocument;
import android.app.appsearch.JoinSpec;
import android.app.appsearch.SearchResult;
import android.app.appsearch.SearchSpec;
import android.content.Context;
import android.content.pm.UserInfo;
import android.os.UserManager;
import android.util.IndentingPrintWriter;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import com.android.server.pm.PackageManagerService;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class AppFunctionDumpHelper {
    private static final String TAG = null;

    static {
        TAG = AppFunctionDumpHelper.class.getSimpleName();
    }

    private AppFunctionDumpHelper() {
    }

    public static void dumpAppFunctionsState(Context context, PrintWriter w) {
        UserManager userManager = (UserManager) context.getSystemService(UserManager.class);
        if (userManager != null) goto L6;
        w.println("Couldn't retrieve UserManager.");
        return;
    L6:
        IndentingPrintWriter pw = new IndentingPrintWriter(w);
        List<UserInfo> userInfos = userManager.getAliveUsers();
        Iterator<UserInfo> r3 = userInfos.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        UserInfo userInfo = r3.next();
        pw.println("AppFunction state for user " + userInfo.getUserHandle().getIdentifier() + ":");
        pw.increaseIndent();
        dumpAppFunctionsStateForUser(context.createContextAsUser(userInfo.getUserHandle(), 0), pw);
        pw.decreaseIndent();
        goto L8
    }

    private static void dumpAppFunctionsStateForUser(Context context, IndentingPrintWriter pw) {
        AppSearchManager appSearchManager = (AppSearchManager) context.getSystemService(AppSearchManager.class);
        if (appSearchManager != null) goto L39;
        pw.println("Couldn't retrieve AppSearchManager.");
        return;
    L39:
        FutureGlobalSearchSession searchSession = new FutureGlobalSearchSession(appSearchManager, new SystemServerInitThreadPool$$ExternalSyntheticLambda0());     // Catch: Exception -> L19
        pw.println();     // Catch: Throwable -> L21
        FutureSearchResults futureSearchResults = (FutureSearchResults) searchSession.search("", buildAppFunctionMetadataSearchSpec()).get();     // Catch: Throwable -> L21
    L40:
        List<SearchResult> searchResultsList = (List) futureSearchResults.getNextPage().get();     // Catch: Throwable -> L12
        Iterator<SearchResult> r4 = searchResultsList.iterator();     // Catch: Throwable -> L12
    L10:
        if (r4.hasNext() == false) goto L15;
        SearchResult searchResult = r4.next();     // Catch: Throwable -> L12
        dumpAppFunctionMetadata(pw, searchResult);     // Catch: Throwable -> L12
        goto L10
    L15:
        if (searchResultsList.isEmpty() == false) goto L40;
        futureSearchResults.close();     // Catch: Throwable -> L21
        searchSession.close();     // Catch: Exception -> L19
        return;
    L12:
        th = move-exception;
        if (futureSearchResults != null) goto L37;
    L29:
        throw th;     // Catch: Throwable -> L21
    L37:
        futureSearchResults.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        searchSession.close();     // Catch: Throwable -> L32
    L34:
        throw th;     // Catch: Exception -> L19
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        pw.println("Failed to dump AppFunction state: " + e);
    }

    private static SearchSpec buildAppFunctionMetadataSearchSpec() {
        SearchSpec runtimeMetadataSearchSpec = new SearchSpec.Builder().addFilterPackageNames(new String[]{PackageManagerService.PLATFORM_PACKAGE_NAME}).addFilterSchemas(new String[]{"AppFunctionRuntimeMetadata"}).build();
        JoinSpec joinSpec = new JoinSpec.Builder("appFunctionStaticMetadataQualifiedId").setNestedSearch("", runtimeMetadataSearchSpec).build();
        return new SearchSpec.Builder().addFilterPackageNames(new String[]{PackageManagerService.PLATFORM_PACKAGE_NAME}).addFilterSchemas(new String[]{"AppFunctionStaticMetadata"}).setJoinSpec(joinSpec).build();
    }

    private static void dumpAppFunctionMetadata(IndentingPrintWriter pw, SearchResult joinedSearchResult) {
        pw.println("AppFunctionMetadata for: " + joinedSearchResult.getGenericDocument().getPropertyString("functionId"));
        pw.increaseIndent();
        pw.println("Static Metadata:");
        pw.increaseIndent();
        writeGenericDocumentProperties(pw, joinedSearchResult.getGenericDocument());
        pw.decreaseIndent();
        pw.println("Runtime Metadata:");
        pw.increaseIndent();
        if (joinedSearchResult.getJoinedResults().isEmpty() == true) goto L5;
        writeGenericDocumentProperties(pw, ((SearchResult) joinedSearchResult.getJoinedResults().getFirst()).getGenericDocument());
    L6:
        pw.decreaseIndent();
        pw.decreaseIndent();
        return;
    L5:
        pw.println("No runtime metadata found.");
        goto L6
    }

    private static void writeGenericDocumentProperties(IndentingPrintWriter pw, GenericDocument genericDocument) {
        Set<String> propertyNames = genericDocument.getPropertyNames();
        pw.println("{");
        pw.increaseIndent();
        Iterator<String> r1 = propertyNames.iterator();
    L4:
        if (r1.hasNext() == false) goto L30;
        String propertyName = r1.next();
        Object propertyValue = genericDocument.getProperty(propertyName);
        pw.print("\"" + propertyName + "\": [");
        if ((propertyValue instanceof GenericDocument[]) == false) goto L15;
        GenericDocument[] documentValues = (GenericDocument[]) propertyValue;
        int i = 0;
    L9:
        if (i >= documentValues.length) goto L29;
        GenericDocument documentValue = documentValues[i];
        writeGenericDocumentProperties(pw, documentValue);
        if (i == (documentValues.length - 1)) goto L13;
        pw.print(", ");
    L13:
        pw.println();
        i = i + 1;
    L29:
        pw.println("]");
        goto L4
    L15:
        int propertyArrLength = Array.getLength(propertyValue);
        int i2 = 0;
    L16:
        if (i2 >= propertyArrLength) goto L29;
        Object propertyElement = Array.get(propertyValue, i2);
        if ((propertyElement instanceof String) == false) goto L21;
        pw.print("\"" + propertyElement + "\"");
    L26:
        if (i2 == (propertyArrLength - 1)) goto L28;
        pw.print(", ");
    L28:
        i2 = i2 + 1;
        goto L16
    L21:
        if ((propertyElement instanceof byte[]) == false) goto L23;
        pw.print(Arrays.toString((byte[]) propertyElement));
        goto L26
    L23:
        if (propertyElement == null) goto L26;
        pw.print(propertyElement.toString());
        goto L26
    L30:
        pw.decreaseIndent();
        pw.println("}");
    }
}
