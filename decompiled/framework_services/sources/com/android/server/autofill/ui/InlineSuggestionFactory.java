package com.android.server.autofill.ui;

import android.service.autofill.Dataset;
import android.service.autofill.FillResponse;
import android.service.autofill.InlinePresentation;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.view.inputmethod.InlineSuggestion;
import android.view.inputmethod.InlineSuggestionInfo;
import android.view.inputmethod.InlineSuggestionsRequest;
import android.widget.inline.InlinePresentationSpec;
import com.android.internal.view.inline.IInlineContentProvider;
import com.android.server.autofill.Helper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class InlineSuggestionFactory {
    private static final String TAG = "InlineSuggestionFactory";

    public static /* synthetic */ void $r8$lambda$N7aMZ2pgItHxYZKhFWmBOJKULlQ(InlineFillUi.InlineSuggestionUiCallback r0, int r1) {
        lambda$createInlineAuthentication$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$OZ32mr93W9cRZZF8hgtcuSLcrLc(InlineFillUi.InlineSuggestionUiCallback r0, Dataset r1, int r2) {
        lambda$createInlineSuggestions$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$W-b8D5LV8mjxDDKFiiqqz7dbxp8, reason: not valid java name */
    public static /* synthetic */ void m2445$r8$lambda$Wb8D5LV8mjxDDKFiiqqz7dbxp8() {
        lambda$createInlineSuggestionTooltip$2();
    }

    public static InlineSuggestion createInlineAuthentication(InlineFillUi.InlineFillUiInfo inlineFillUiInfo, FillResponse response, final InlineFillUi.InlineSuggestionUiCallback uiCallback) {
        InlinePresentation inlineAuthentication = response.getInlinePresentation();
        final int requestId = response.getRequestId();
        if ((response.getFlags() & 8) == 0) goto L5;
        boolean ignoreHostSpec = true;
    L7:
        return createInlineSuggestion(inlineFillUiInfo, "android:autofill", "android:autofill:action", new InlineSuggestionFactory$$ExternalSyntheticLambda0(uiCallback, requestId), mergedInlinePresentation(inlineFillUiInfo.mInlineRequest, 0, inlineAuthentication, ignoreHostSpec), createInlineSuggestionTooltip(inlineFillUiInfo.mInlineRequest, inlineFillUiInfo, "android:autofill", response.getInlineTooltipPresentation()), uiCallback);
    L5:
        ignoreHostSpec = false;
        goto L7
    }

    private static /* synthetic */ void lambda$createInlineAuthentication$0(InlineFillUi.InlineSuggestionUiCallback uiCallback, int requestId) {
        uiCallback.authenticate(requestId, 65535);
    }

    public static SparseArray<Pair<Dataset, InlineSuggestion>> createInlineSuggestions(InlineFillUi.InlineFillUiInfo inlineFillUiInfo, String suggestionSource, List<Dataset> datasets, final InlineFillUi.InlineSuggestionUiCallback uiCallback, boolean ignoreHostSpec) {
        InlineFillUi.InlineFillUiInfo r0 = inlineFillUiInfo;
        String r1 = suggestionSource;
        if (Helper.sDebug == false) goto L5;
        Slog.d(TAG, "createInlineSuggestions(source=" + r1 + ") called");
    L5:
        InlineSuggestionsRequest request = r0.mInlineRequest;
        SparseArray<Pair<Dataset, InlineSuggestion>> response = new SparseArray(datasets.size());
        boolean hasTooltip = false;
        int datasetIndex = 0;
    L7:
        if (datasetIndex >= datasets.size()) goto L28;
        final Dataset dataset = datasets.get(datasetIndex);
        int fieldIndex = dataset.getFieldIds().indexOf(r0.mFocusedId);
        if (fieldIndex >= 0) goto L11;
        Slog.w(TAG, "AutofillId=" + r0.mFocusedId + " not found in dataset");
    L26:
        datasetIndex = datasetIndex + 1;
        r0 = inlineFillUiInfo;
        r1 = suggestionSource;
        goto L7
    L11:
        InlinePresentation inlinePresentation = dataset.getFieldInlinePresentation(fieldIndex);
        if (inlinePresentation != null) goto L15;
        Slog.w(TAG, "InlinePresentation not found in dataset");
        goto L26
    L15:
        if (dataset.getAuthentication() != null) goto L17;
        String suggestionType = "android:autofill:suggestion";
    L18:
        final int index = datasetIndex;
        if (hasTooltip == true) goto L24;
        InlineSuggestion inlineSuggestionTooltip = createInlineSuggestionTooltip(request, r0, r1, dataset.getFieldInlineTooltipPresentation(fieldIndex));
        if (inlineSuggestionTooltip == null) goto L23;
        boolean hasTooltip2 = true;
        InlineSuggestion inlineSuggestionTooltip2 = inlineSuggestionTooltip;
    L25:
        InlineSuggestion inlineSuggestion = createInlineSuggestion(r0, r1, suggestionType, new InlineSuggestionFactory$$ExternalSyntheticLambda2(uiCallback, dataset, index), mergedInlinePresentation(request, datasetIndex, inlinePresentation, ignoreHostSpec), inlineSuggestionTooltip2, uiCallback);
        response.append(datasetIndex, Pair.create(dataset, inlineSuggestion));
        hasTooltip = hasTooltip2;
        goto L26
    L23:
        hasTooltip2 = hasTooltip;
        inlineSuggestionTooltip2 = inlineSuggestionTooltip;
        goto L25
    L24:
        hasTooltip2 = hasTooltip;
        inlineSuggestionTooltip2 = null;
        goto L25
    L17:
        suggestionType = "android:autofill:action";
        goto L18
    L28:
        return response;
    }

    private static /* synthetic */ void lambda$createInlineSuggestions$1(InlineFillUi.InlineSuggestionUiCallback uiCallback, Dataset dataset, int index) {
        uiCallback.autofill(dataset, index);
    }

    private static InlineSuggestion createInlineSuggestion(InlineFillUi.InlineFillUiInfo inlineFillUiInfo, String suggestionSource, String suggestionType, Runnable onClickAction, InlinePresentation inlinePresentation, InlineSuggestion tooltip, InlineFillUi.InlineSuggestionUiCallback uiCallback) {
        InlineSuggestionInfo inlineSuggestionInfo = new InlineSuggestionInfo(inlinePresentation.getInlinePresentationSpec(), suggestionSource, inlinePresentation.getAutofillHints(), suggestionType, inlinePresentation.isPinned(), tooltip);
        return new InlineSuggestion(inlineSuggestionInfo, createInlineContentProvider(inlineFillUiInfo, inlinePresentation, onClickAction, uiCallback));
    }

    private static InlinePresentation mergedInlinePresentation(InlineSuggestionsRequest request, int index, InlinePresentation inlinePresentation, boolean ignoreHostSpec) {
        List<InlinePresentationSpec> specs = request.getInlinePresentationSpecs();
        if (specs.isEmpty() == false) goto L5;
        return inlinePresentation;
    L5:
        InlinePresentationSpec specFromHost = specs.get(Math.min(specs.size() - 1, index));
        if (ignoreHostSpec == false) goto L8;
        InlinePresentationSpec specToUse = inlinePresentation.getInlinePresentationSpec();
    L9:
        InlinePresentationSpec mergedInlinePresentation = new InlinePresentationSpec.Builder(inlinePresentation.getInlinePresentationSpec().getMinSize(), inlinePresentation.getInlinePresentationSpec().getMaxSize()).setStyle(specToUse.getStyle()).build();
        return new InlinePresentation(inlinePresentation.getSlice(), mergedInlinePresentation, inlinePresentation.isPinned());
    L8:
        specToUse = specFromHost;
        goto L9
    }

    private static InlineSuggestion createInlineSuggestionTooltip(InlineSuggestionsRequest request, InlineFillUi.InlineFillUiInfo inlineFillUiInfo, String suggestionSource, InlinePresentation tooltipPresentation) {
        if (tooltipPresentation != null) goto L5;
        return null;
    L5:
        InlinePresentationSpec spec = request.getInlineTooltipPresentationSpec();
        if (spec != null) goto L8;
        InlinePresentationSpec mergedSpec = tooltipPresentation.getInlinePresentationSpec();
    L9:
        InlineFillUi.InlineSuggestionUiCallback uiCallback = new AnonymousClass1();
        InlinePresentation tooltipInline = new InlinePresentation(tooltipPresentation.getSlice(), mergedSpec, false);
        IInlineContentProvider tooltipContentProvider = createInlineContentProvider(inlineFillUiInfo, tooltipInline, new InlineSuggestionFactory$$ExternalSyntheticLambda1(), uiCallback);
        InlineSuggestionInfo tooltipInlineSuggestionInfo = new InlineSuggestionInfo(mergedSpec, suggestionSource, null, "android:autofill:suggestion", false, null);
        return new InlineSuggestion(tooltipInlineSuggestionInfo, tooltipContentProvider);
    L8:
        mergedSpec = new InlinePresentationSpec.Builder(tooltipPresentation.getInlinePresentationSpec().getMinSize(), tooltipPresentation.getInlinePresentationSpec().getMaxSize()).setStyle(spec.getStyle()).build();
        goto L9
    }

    private static /* synthetic */ void lambda$createInlineSuggestionTooltip$2() {
    }

    private static IInlineContentProvider createInlineContentProvider(InlineFillUi.InlineFillUiInfo inlineFillUiInfo, InlinePresentation inlinePresentation, Runnable onClickAction, InlineFillUi.InlineSuggestionUiCallback uiCallback) {
        RemoteInlineSuggestionViewConnector remoteInlineSuggestionViewConnector = new RemoteInlineSuggestionViewConnector(inlineFillUiInfo, inlinePresentation, onClickAction, uiCallback);
        return new InlineContentProviderImpl(remoteInlineSuggestionViewConnector, null);
    }

    private InlineSuggestionFactory() {
    }
}
